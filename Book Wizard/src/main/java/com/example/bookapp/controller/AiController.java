package com.example.bookapp.controller;

import com.example.bookapp.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/generate-scene")
    public Map<String, String> generateScene(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        String content = geminiService.generateScene(prompt);
        return Map.of("content", content);
    }

}
