package com.maidf.spai.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChatController {
    @Autowired
    private OllamaChatModel chatModel;
    
    @GetMapping("/chat/{msg}")
    public String chat(@PathVariable String msg) {
        return chatModel.call(msg);
    }
    
}
