package com.example.springweb.controller;

import com.example.springweb.pojo.Grade;
import com.example.springweb.service.GradeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/grade")
public class grade {
    @Resource(name = "GradeService")
    private GradeService gradeService;
    @RequestMapping("/list")
    public String gradeList(Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        PageInfo<Grade> pageInfo=gradeService.queryAll(pageNum);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("gradeList",pageInfo.getList());
        return "grade/list";
    }
    @PostMapping("/search")
    public String search(Model model,String searchContent){
        model.addAttribute("gradeList",gradeService.querySingle(searchContent));
        return "grade/list";
    }
    @GetMapping("/add")
    public String gradeAdd(){
        return "grade/add";
    }
    @PostMapping("/add")
    public String gradeAdd(Grade grade,Model model){
        if(gradeService.addGrade(grade)==1){
            return "redirect:/grade/list";
        }else {
            model.addAttribute("str","补选失败");
            return "error";
        }
    }
    @GetMapping("/ReElection")
    public String toReElection(String stuNumber,Model model){
        model.addAttribute("stuNumber",stuNumber);
        model.addAttribute("CourseList",gradeService.queryElect(stuNumber));
        return "grade/ReElection";
    }
    @GetMapping("/editor")
    public String gradeEditor(Model model,String stuNumber,int couId){
        model.addAttribute("grade",gradeService.queryByNum(stuNumber,couId));
        return "grade/editor";
    }
    @PostMapping("/editor")
    public String gradeEditor(Grade grade,Model model){
        if(gradeService.updateGrade(grade)==1){
            return "redirect:/grade/list";
        }else {
            model.addAttribute("str","更新失败");
            return "error";
        }
    }
    @RequestMapping("/delete")
    public String gradeDelete(String stuNumber,int couId,Model model){
        if(gradeService.deleteGrade(stuNumber,couId)==1){
            return "redirect:/grade/list";
        }else {
            model.addAttribute("str","删除失败");
            return "error";
        }
    }
}
