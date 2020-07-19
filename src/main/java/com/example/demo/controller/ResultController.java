package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

public class ResultController {
    @GetMapping("/result")
    public ModelAndView getResult(){
        System.out.println("dsdfsdfsfd");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");

        //Map<String, String> errors = new HashMap<>();
        //modelAndView.addObject("errors", errors);

        modelAndView.addObject("newCredential", new Form());
        modelAndView.addObject("errors", new HashMap<String, String>());
        return modelAndView;
    }

}
