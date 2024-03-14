package com.example.springweb.service;

import com.example.springweb.dao.studentMapper;
import com.example.springweb.pojo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service("StudentService")
public class StudentService {
    @Value("${imgFile}")
    private String dirPath;
    @Resource(name = "studentMapper")
    private studentMapper studentMapper;
    public PageInfo<Student> queryAll(int pageNum){
        PageHelper.startPage(pageNum,3);
        List<Student> studentList= studentMapper.queryAll();
        return new PageInfo<Student>(studentList);
    }
    public Student queryByNum(String stuNumber){
        return studentMapper.queryByNum(stuNumber);
    }
    public int addStu(Student student,MultipartFile file){
        upFile(student,file);
        return studentMapper.addStu(student);
    }
    public boolean updateStu(Student student,MultipartFile file){
        if(file.isEmpty()){     //图片未修改
            studentMapper.updateStu(student);
            return true;
        }else{
            if(upFile(student,file)){
                studentMapper.updateStu(student);
                return true;
            }else {
                System.out.println("上传失败");
                return false;
            }
        }
    }
    public int deleteStu(String stuNumber){
        Student student=queryByNum(stuNumber);
        File file=new File(dirPath+student.getStuPic());
        if(file.exists()){
            file.delete();
        }else {
            System.out.println("文件不存在");
        }
        return studentMapper.deleteStu(stuNumber);
    }
    boolean upFile(Student student,MultipartFile file){
        Logger logger= LoggerFactory.getLogger(StudentService.class);
        String fileName=file.getOriginalFilename();
        String newFileName= UUID.randomUUID()+"-"+fileName;
        student.setStuPic(newFileName);
        File filePath=new File(dirPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        try{
            file.transferTo(new File(dirPath,newFileName));
        }catch (Exception e){
            logger.warn("错误信息为"+e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
