package com.repair.ai.engine.service;

import com.openai.models.responses.StructuredResponse;
import com.openai.models.responses.StructuredResponseOutputItem;
import com.openai.models.responses.StructuredResponseOutputMessage;
import com.repair.ai.engine.models.entity.ConversationContext;
import com.repair.ai.engine.models.wrapper.AIResponse;
import com.repair.ai.engine.models.wrapper.Repair;
import com.repair.ai.engine.models.wrapper.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairService {

    @Autowired
    private LLMService llmService;

    public AIResponse repairConversation(UserMessage userMessage, ConversationContext conversationContext) {

        //TODO: Implement conversation state machine
        return getRepair(userMessage.getMessage());
    }

    public Repair getRepair(String message) {

        StructuredResponse<?> llmRepair = llmService.callOpenAiModel(message, Repair.class);


        return llmRepair.output().stream()
                .map(StructuredResponseOutputItem::message)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(StructuredResponseOutputMessage::content)
                .map(List::getFirst)
                .map(StructuredResponseOutputMessage.Content::asOutputText)
                .filter(Repair.class::isInstance)
                .map(Repair.class::cast)
                .findFirst().orElse(null);
    }
}
