package com.example.springweb.controller;

import com.example.springweb.pojo.Student;
import com.example.springweb.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.util.List;


@Controller
@RequestMapping("/student")
public class student {
    @Resource(name = "StudentService")
    private StudentService studentService;
    @RequestMapping("/list")
    public String stuList(Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        PageInfo<Student> pageInfo=studentService.queryAll(pageNum);
        List<Student> StudentList=pageInfo.getList();
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("StudentList",StudentList);
        return "student/list";
    }
    @PostMapping("/search")
    public String search(String stuNumber,Model model){
        model.addAttribute("StudentList",studentService.queryByNum(stuNumber));
        return "student/list";
    }
    @GetMapping("/add")
    public String stuAdd(@ModelAttribute(value = "student") Student student){
        return "student/add";
    }
    @PostMapping("/add")
    public String stuAdd(@Validated @ModelAttribute(value = "student") Student student,
                         BindingResult bindingResult,
                         @RequestParam(value = "file") MultipartFile file){
        if(bindingResult.hasErrors()){
            return "student/add";
        }else {
            studentService.addStu(student,file);
            return "redirect:/student/list";
        }
    }
    @GetMapping("/editor")
    public String stuEditor(Model model,String stuNumber,@ModelAttribute(value = "student") Student student){
        model.addAttribute("Stu",studentService.queryByNum(stuNumber));
        return "student/editor";
    }
    @PostMapping("/editor")
    public String stuEditor(@Validated @ModelAttribute(value = "student") Student student,
                            BindingResult bindingResult,
                            @RequestParam(value = "file") MultipartFile file,
                            String StuNum,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("Stu",studentService.queryByNum(StuNum));
            return "student/editor";
        }
        studentService.updateStu(student,file);
        return "redirect:/student/list";
    }
    @RequestMapping("/info")
    public String stuInfo(Model model,String stuNumber){
        model.addAttribute("Stu",studentService.queryByNum(stuNumber));
        return "student/info";
    }
    @RequestMapping("/delete")
    public String deleteStu(String stuNumber){
        studentService.deleteStu(stuNumber);
        return "redirect:/student/list";
    }
}
