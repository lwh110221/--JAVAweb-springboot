package com.example.springweb.service;

import com.example.springweb.dao.gradeMapper;
import com.example.springweb.dao.studentMapper;
import com.example.springweb.pojo.Course;
import com.example.springweb.pojo.Grade;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("GradeService")
public class GradeService {
    @Resource(name = "gradeMapper")
    private gradeMapper gradeMapper;
    @Resource(name = "studentMapper")
    private studentMapper studentMapper;
    public PageInfo<Grade> queryAll(int pageNum){
        PageHelper.startPage(pageNum,5);
        return new PageInfo<Grade>(gradeMapper.queryAll());
    }
    public int deleteGrade(String stuNumber,int couId){
        return gradeMapper.deleteGrade(stuNumber,couId);
    }
    public List<Course> queryElect(String stuNumber){
        String major=studentMapper.queryByNum(stuNumber).getMajor();
        return gradeMapper.queryElect(stuNumber, major);
    }
    public int addGrade(Grade grade){
        return gradeMapper.addGrade(grade);
    }
    public Grade queryByNum(String stuNumber,int couId){
        return gradeMapper.queryByNum(stuNumber,couId);
    }
    public List<Course> querySingle(String searchContent){
        return gradeMapper.querySingle(searchContent);
    }
    public int updateGrade(Grade grade){
        return gradeMapper.updateGrade(grade);
    }
 }
