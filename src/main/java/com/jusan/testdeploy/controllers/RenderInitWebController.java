package com.jusan.testdeploy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RenderInitWebController {

    @GetMapping("/page1")
    public String renderPage1() {
        return "page1";
    }

    @GetMapping("/page2")
    public String renderPage2() {
        return "page2";
    }

    @GetMapping("/page3")
    public String renderPage3() {
        return "page3";
    }
}