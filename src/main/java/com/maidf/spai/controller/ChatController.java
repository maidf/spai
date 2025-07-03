package com.maidf.spai.controller;

import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
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

        SystemMessage system = new SystemMessage("直接返回结果,结果格式如下: {names:[\"小可\", \"小艾\"]}");
        UserMessage user = new UserMessage(msg);

        ChatResponse res = chatModel.call(new Prompt(system, user));

        String str = res.getResult().getOutput().getText();
        System.out.println(str);
        return str;
    }

}
