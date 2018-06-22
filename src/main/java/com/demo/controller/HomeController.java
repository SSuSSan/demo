package com.demo.controller;

import com.demo.model.Question;
import com.demo.model.ViewObject;
import com.demo.service.QuestionService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @RequestMapping(path = {"/", "/index"})
    public String index(Model model){
        List<Question> questions = questionService.getLatestQuestions(0,0,10);
        List<ViewObject> vos = new ArrayList<ViewObject>();
        for(Question question: questions){
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("user", userService.getUser(question.getUserId()));
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        return "index";
    }
}
