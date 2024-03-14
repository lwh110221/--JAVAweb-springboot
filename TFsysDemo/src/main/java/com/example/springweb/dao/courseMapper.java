package com.example.springweb.dao;

import com.example.springweb.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("courseMapper")
public interface courseMapper {
    int addCou(Course course);
    int deleteCou(int couId);
    int updateCou(Course course);
    List<Course> queryAllCom();
    List<Course> queryAllSoft();
    List<Course> queryAll();
    Course queryById(int couId);
}
