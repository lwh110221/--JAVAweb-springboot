package com.example.springweb.controller;

import com.example.springweb.pojo.Course;
import com.example.springweb.service.CourseService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/course")
public class course {
    @Resource(name = "CourseService")
    private CourseService courseService;
    @RequestMapping("/list")
    public String courseList(Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                             @RequestParam(value = "major",defaultValue = "总专业") String major){
        String majorName;
        PageInfo<Course> pageInfo=null;
        if(major.equals("总专业")){
            majorName="总专业";
            pageInfo=courseService.queryAll(pageNum);
        }else if(major.equals("软件工程")){
            majorName="软件工程";
            pageInfo=courseService.queryAllSoft(pageNum);
        }else {
            majorName="计算机科学与技术";
            pageInfo=courseService.queryAllCom(pageNum);
        }
        model.addAttribute("major",majorName);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("CouList",pageInfo.getList());
        return "course/list";
    }
    @GetMapping("/add")
    public String courseAdd(){
        return "course/add";
    }
    @PostMapping("/add")
    public String courseAdd(Course course,Model model){
        if(courseService.addCou(course)==1) {
            return "redirect:/course/list";
        }else {
            model.addAttribute("str","添加失败");
            return "error";
        }
    }
    @PostMapping("/editor")
    public String courseEditor(Course course,Model model){
        if(courseService.updateCou(course)==1){
            return "redirect:/course/list";
        }else{
            model.addAttribute("str","编辑失败");
            return "error";
        }
    }
    @GetMapping("/editor")
    public String courseEditor(Model model,int couId){
        model.addAttribute("cou",courseService.queryById(couId));
        return "course/editor";
    }
    @RequestMapping("/delete")
    public String delete(int couId,Model model){
        if(courseService.deleteCou(couId)==1){
            return "redirect:/course/list";
        }else {
            model.addAttribute("str","删除失败");
            return "error";
        }
    }
}
