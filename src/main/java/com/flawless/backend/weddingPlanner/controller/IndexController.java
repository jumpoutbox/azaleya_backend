package com.flawless.backend.weddingPlanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@Controller
public class IndexController {

    @GetMapping
    public String index(){
        return "index";
    }
}
