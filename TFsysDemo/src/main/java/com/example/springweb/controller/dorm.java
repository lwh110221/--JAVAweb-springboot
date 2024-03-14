package com.example.springweb.controller;

import com.example.springweb.pojo.Dorm;
import com.example.springweb.service.dormService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/dorm")
public class dorm {
    @Resource(name = "dormService")
    private dormService dormService;
    @RequestMapping("/list")
    public String dormList(Model model,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        List<Dorm> dormList=dormService.queryAll(pageNum).getList();
        model.addAttribute("pageInfo",dormService.queryAll(pageNum));
        model.addAttribute("dormList",dormList);
        return "dorm/list";
    }
    @PostMapping("/search")
    public String search(String dormName,Model model){
        model.addAttribute("dormList",dormService.querySingle(dormName));
        return "dorm/list";
    }
    @GetMapping("/add")
    public String dormAdd(@ModelAttribute(value = "dorm") Dorm dorm){
        return "dorm/add";
    }
    @PostMapping("/add")
    public String dormAdd(@Validated @ModelAttribute(value = "dorm") Dorm dorm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "dorm/add";
        }
        if(dormService.addDorm(dorm)==1){
            return "redirect:/dorm/list";
        }else {
            model.addAttribute("str","添加失败");
            return "error";
        }
    }
    @PostMapping("/editor")
    public String dormEditor(@Validated @ModelAttribute(value = "dorm") Dorm dorm, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("dormList",dormService.queryById(dorm.getDormId()));
            return "dorm/editor";
        }
        if(dormService.updateDorm(dorm)==1){
            return "redirect:/dorm/list";
        }else{
            model.addAttribute("str","编辑失败");
            return "redirect:/dorm/list";
        }
    }
    @GetMapping("/editor")
    public String dormEditor(int dormId,Model model,@ModelAttribute(value = "dorm") Dorm dorm){
        model.addAttribute("dormList", dormService.queryById(dormId));
        return "dorm/editor";
    }
    @RequestMapping("/delete")
    public String dormDelete(int dormId,Model model){
        if(dormService.deleteDorm(dormId)==1){
            return "redirect:/dorm/list";
        }else {
            model.addAttribute("str","删除失败");
            return "error";
        }
    }
}
