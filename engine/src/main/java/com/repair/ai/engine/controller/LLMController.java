package com.repair.ai.engine.controller;

import com.repair.ai.engine.models.wrapper.Repair;
import com.repair.ai.engine.service.LLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/llm")
public class LLMController {

    @Autowired
    private LLMService llmService;


    @GetMapping("/test")
    public ResponseEntity<Repair> test() {
        return ResponseEntity.ok(llmService.testingApiCallToOpenAi());
    }

}
