package com.example.springweb;

import com.example.springweb.pojo.Course;
import com.example.springweb.pojo.score.Subject;
import com.example.springweb.service.GradeService;
import com.example.springweb.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class SpringwebApplicationTests {
    @Autowired
    private Utils utils;
    @Test
    void contextLoads() {
//        ScoreService gradeMapper=(ScoreService) utils.getBean("ScoreService");
//        List<Subject> list=gradeMapper.queryByName("大学英语4");
//        for (Subject course: list) {
//            System.out.println(course);
//        }
        String name="兰五642";
        String a,c;
        int b,index=0;
        for(int i=0;i<name.length();i++){
            if(!(19968<=(int)name.charAt(i)&&(int)name.charAt(i)<=40869)){
                index=name.indexOf(name.charAt(i));
                break;
            }
        }
        a=name.substring(0,index);
        c=name.substring(index);
        System.out.println(a);
        System.out.println(Integer.parseInt(c));

    }

}
