package com.example.springweb.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Login {
    private int id;
    private String email;
    private String password;
    private String salt;
    private LocalDateTime validation_time;
    private int is_valid;
    private String confirm_code;
}
