package com.js.dj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Controller
public class CommentController {
    private final Queue<String> commentList = new ConcurrentLinkedQueue<>();

    @GetMapping("/comment")
    public String showCommentPage(Model model) {
        model.addAttribute("comments", commentList);
        return "comment"; // loads comment.html
    }

    @PostMapping("/api/v1/app/comment")
    public String submitComment(@RequestParam String username,
                                @RequestParam String message,
                                Model model) {
        String formattedComment = username + ": " + message;
        commentList.add(formattedComment); // add to shared list
        model.addAttribute("comments", commentList);
        model.addAttribute("successMessage", "Comment submitted!");
        return "comment";
    }
}
