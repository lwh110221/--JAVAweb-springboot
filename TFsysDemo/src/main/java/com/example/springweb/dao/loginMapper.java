package com.example.springweb.dao;

import com.example.springweb.pojo.Login;
import com.example.springweb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository("loginMapper")
public interface loginMapper {
    int addUser(Login login);
    List<Login> queryByEmail(String email);
    int queryValid(String email);
    int updateValid(String confirmCode);
    Login queryTime(String confirmCode);

}
