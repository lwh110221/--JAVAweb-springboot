package com.example.springweb.dao;

import com.example.springweb.SpringwebApplication;
import com.example.springweb.pojo.score.AllPoint;
import com.example.springweb.pojo.score.Personal;
import com.example.springweb.pojo.score.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository("scoreMapper")
public interface scoreMapper {
    List<Subject> queryByName(String couName);
    List<Personal> queryByNum(String stuNumber);
    List<AllPoint> queryByMajor(String major);
}



