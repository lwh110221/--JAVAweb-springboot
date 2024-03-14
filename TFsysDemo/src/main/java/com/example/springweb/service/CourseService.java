package com.example.springweb.service;

import com.example.springweb.dao.courseMapper;
import com.example.springweb.pojo.Course;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("CourseService")
public class CourseService {
    @Resource(name = "courseMapper")
    private courseMapper courseMapper;
    public PageInfo<Course> queryAllCom(int pageNum){
        PageHelper.startPage(pageNum,4);
        return new PageInfo<Course>(courseMapper.queryAllCom());
    }
    public PageInfo<Course> queryAllSoft(int pageNum){
        PageHelper.startPage(pageNum,4);
        return new PageInfo<Course>(courseMapper.queryAllSoft());
    }
    public PageInfo<Course> queryAll(int pageNum){
        PageHelper.startPage(pageNum,4);
        return new PageInfo<Course>(courseMapper.queryAll());
    }
    public int addCou(Course course){
        return courseMapper.addCou(course);
    }
    public int updateCou(Course course){
        return courseMapper.updateCou(course);
    }
    public int deleteCou(int couId){
        return courseMapper.deleteCou(couId);
    }
    public Course queryById(int couId){
        return courseMapper.queryById(couId);
    }
}
