package com.js.dj.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/app")
public class AppController {

    @GetMapping("/info")
    public String getAppInfo() {
        return "Internet Banking Application - Version 1.0";
    }

    // Endpoint to add a comment
//    @GetMapping("/comment")
//    public String addComment() {
//        return "Comment added by ";
//    }
}
