package com.repair.ai.engine.service;

import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.*;
import com.repair.ai.engine.models.wrapper.Repair;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LLMService {

    @Autowired
    private OpenAIClient openAIClient;

    public void testingApiCallToOpenAi() {

        String testInput = "My kitchen sink won't drain properly. The water goes down very slowly. Please diagnose the issue and tell me the repair.";

        StructuredResponseCreateParams<Repair> params = ResponseCreateParams.builder()
                .input(testInput)
                .model(ChatModel.GPT_4O)
                .text(Repair.class)
                .build();

        StructuredResponse<Repair> repair = openAIClient.responses().create(params);
        log.info(repair);
    }
}
