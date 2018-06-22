package com.demo.controller;

import com.demo.model.Question;
import com.demo.model.ViewObject;
import com.demo.service.QuestionService;
import com.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    private List<ViewObject> getQuestions(int userId, int offset, int limit) {
        List<Question> questions = questionService.getLatestQuestions(userId, offset, limit);
        List<ViewObject> vos = new ArrayList<ViewObject>();
        for (Question question : questions) {
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("user", userService.getUser(question.getUserId()));
            vos.add(vo);
        }
        return vos;
    }

    @RequestMapping(path = {"/", "/index"})
    public String index(Model model){
        List<ViewObject> vos = getQuestions(0, 0, 10);
        model.addAttribute("vos", vos);
        return "index";
    }

    @RequestMapping(path = {"/user/{userId}"})
    public String UserIndex(Model model,
                            @PathVariable("userId") int userId){
        List<ViewObject> vos = getQuestions(userId, 0, 1);
        model.addAttribute("vos", vos);
        return "index";
    }
}
