package com.example.springweb.dao;

import com.example.springweb.pojo.Dorm;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("dormMapper")
public interface dormMapper {
    List<Dorm> queryAll();
    Dorm querySingle(String dormAddress,int dormNum);
    Dorm queryById(int dormId);
    int addDorm(Dorm dorm);
    int updateDorm(Dorm dorm);
    int deleteDorm(int dormId);
}
