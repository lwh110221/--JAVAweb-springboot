package com.example.springweb.pojo;

import lombok.Data;

@Data
public class Grade {
    private String stuNumber;
    private int couId;
    private int grade;
    private float point;
    private Student student;
    private Course course;
}
