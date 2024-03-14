package com.example.springweb.controller;

import com.example.springweb.pojo.score.Personal;
import com.example.springweb.pojo.score.Subject;
import com.example.springweb.service.ScoreService;
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
@RequestMapping("/score")
public class score {
    @Resource(name = "ScoreService")
    private ScoreService scoreService;
    @RequestMapping("/personalList")
    public String scoreList(Model model,@RequestParam(value = "stuNumber",defaultValue = "") String stuNumber){
        List<Personal> list=scoreService.queryByNum(stuNumber);
        model.addAttribute("personList",list);
        model.addAttribute("stuNumber",stuNumber);
        model.addAttribute("avgPoint",scoreService.countPoint());
        return "score/personalList";
    }
    @RequestMapping("/allList")
    public String allList(Model model,@RequestParam(value = "couName",defaultValue = "") String couName){
        List<Subject> list=scoreService.queryByName(couName);
        model.addAttribute("couName",couName);
        model.addAttribute("SubjectList",scoreService.queryByName(couName));
        return "score/allList";
    }
    @RequestMapping("/pointList")
    public String pointList(Model model,@RequestParam(value = "major",defaultValue = "请选择专业") String major){
        model.addAttribute("major",major);
        model.addAttribute("pointList",scoreService.queryByMajor(major));
        return "score/pointList";
    }
}
