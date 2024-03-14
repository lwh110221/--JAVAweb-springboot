package com.example.springweb.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@Validated
public class Student {
    @NotBlank (message = "姓名不能为空")
    private String name;
    @NotBlank (message = "学号不能为空")
    @Length(min = 8,max = 20,message = "学号不合法（8-10个字符）")
    private String stuNumber;
    @Range(min=1,max=60,message = "年龄不合法")
    private int age;
    private int stuId;
    @NotBlank (message = "宿舍地址不能为空")
    @Pattern(regexp = "[\u4e00-\u9fa5]+[0-9][0-9][0-9]",message = "宿舍地址格式为‘地址+宿舍号’")
    private String dormNumber;
    private String sex;
    @NotBlank (message = "专业班级不能为空")
//    @Pattern(regexp = "[\u4e00-\u9fa5]+[0-9]{4}",message = "专业班级格式为‘’")
    private String majorClass;
    @NotNull(message = "入学日期必须填写")
    private Date stuDay;
    private String stuPic;
    @NotBlank (message = "专业全称必须填写")
    private String major;
}
