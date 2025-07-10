package com.repair.ai.engine.controller;

import com.repair.ai.engine.models.entity.ConversationContext;
import com.repair.ai.engine.models.wrapper.AIResponse;
import com.repair.ai.engine.models.wrapper.UserMessage;
import com.repair.ai.engine.service.ConversationContextService;
import com.repair.ai.engine.service.RepairService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;;

    @Autowired
    private ConversationContextService conversationContextService;

    @GetMapping("/conversation/{sessionId}")
    public ResponseEntity<AIResponse> repairConversation(@PathVariable String sessionId, @RequestBody @NotNull UserMessage userMessage) {
        ConversationContext context = conversationContextService.getConversationContext(sessionId);
        return ResponseEntity.ok(repairService.repairConversation(userMessage, context));
    }

}
