package com.example.springweb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class EmailService {
    @Value("${spring.mail.username}")
    private String sendEmailName;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    private TemplateEngine templateEngine;
    public void sendEmail(String activeUrl,String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            /*设置邮件基本信息*/
            mimeMessageHelper.setSubject("欢迎来到学生成绩管理系统：个人账号激活");
            mimeMessageHelper.setFrom(sendEmailName);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSentDate(new Date());
            /*设置邮件内容模板*/
            Context context = new Context();
            context.setVariable("activeUrl", activeUrl);
            String text = templateEngine.process("email.html", context);
            mimeMessageHelper.setText(text, true);
            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

}
