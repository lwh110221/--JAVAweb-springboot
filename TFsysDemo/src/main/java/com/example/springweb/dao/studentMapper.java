package com.example.springweb.dao;

import com.example.springweb.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("studentMapper")
public interface studentMapper {
    List<Student> queryAll();
    Student queryByNum(String stuNumber);
    int addStu(Student student);
    int updateStu(Student student);
    int deleteStu(String stuNumber);
}
