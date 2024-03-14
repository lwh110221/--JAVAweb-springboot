package com.example.springweb.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.example.springweb.dao.loginMapper;
import com.example.springweb.pojo.Login;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("loginService")
public class loginService {
    @Value("${severUrl}")
    String severUrl;
    @Resource(name ="loginMapper")
    private loginMapper loginMapper;
    @Resource
    private EmailService emailService;
    /*用户登录*/
    public Map<String,Object> loginIn(Login viewLogin,HttpSession session){
        Map<String, Object> map = new HashMap<>();
        List<Login> loginList =loginMapper.queryByEmail(viewLogin.getEmail());
        if(loginList.isEmpty()) {
            map.put("message","邮箱未注册");
            return map;
        }
        else if(loginList.size()>1) {
            map.put("message","账号信息异常，请联系管理员");
            return map;
        }
        else if(loginList.get(0).getIs_valid()==0) {
            map.put("message","账号未激活");
            return map;
        }
        else{
            String viewPassword=SecureUtil.md5(viewLogin.getPassword()+loginList.get(0).getSalt());
            if(!viewPassword.equals(loginList.get(0).getPassword())) map.put("message","密码错误");
            else {
                map.put("message","登录成功");
                session.setAttribute("USER",viewLogin);
            }
            return map;
        }
    }
    /*注册用户*/
    public Map<String,Object> addUser(Login viewLogin) {
        Map<String, Object> map = new HashMap<>();
        if(viewLogin.getEmail().equals("")){
            map.put("message","邮件不能为空");
            return map;
        }else if(viewLogin.getPassword().equals("")){
            map.put("message","密码不能为空");
            return map;
        }else if(!loginMapper.queryByEmail(viewLogin.getEmail()).isEmpty()){
            map.put("message","该邮件已注册");
            return map;
        }else {
            //生成数据
            String confirmCode = IdUtil.getSnowflake(1, 1).nextIdStr();
            String salt = RandomUtil.randomString(9);
            String password = SecureUtil.md5(viewLogin.getPassword() + salt); //密码加密
            LocalDateTime ldf = LocalDateTime.now().plusDays(1);
            //构造login对象
            viewLogin.setConfirm_code(confirmCode);
            viewLogin.setPassword(password);
            viewLogin.setSalt(salt);
            viewLogin.setValidation_time(ldf);
            int result = loginMapper.addUser(viewLogin);
            if (result > 0) {
                emailService.sendEmail(severUrl+confirmCode, viewLogin.getEmail());
                map.put("message", "注册成功,请前往邮件验证");
                map.put("login", viewLogin);
            } else {
                map.put("message", "注册失败");
            }
            return map;
        }
    }
    public Map<String,Object> validMail(String confirmCode){
        Map<String,Object> resultMap=new HashMap<>();
        LocalDateTime time=loginMapper.queryTime(confirmCode).getValidation_time();
        if(time.isBefore(LocalDateTime.now())){
            resultMap.put("code",500);
            resultMap.put("message","该邮件的激活时间已失效，请重新接受邮件激活");
        }else {
            if(loginMapper.updateValid(confirmCode)==1){
                resultMap.put("code",200);
                resultMap.put("message","恭喜你，激活成功");
            }else{
                resultMap.put("code",500);
                resultMap.put("message","激活失败");
            }
        }
        return resultMap;
    }

}
