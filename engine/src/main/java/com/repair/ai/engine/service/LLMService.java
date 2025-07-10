package com.repair.ai.engine.service;

import com.openai.client.OpenAIClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.ResponseCreateParams;
import com.openai.models.responses.StructuredResponse;
import com.openai.models.responses.StructuredResponseCreateParams;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LLMService {

    @Autowired
    private OpenAIClient openAIClient;

    public StructuredResponse<?> callOpenAiModel(String message, Class<?> klass) {
        log.info("Calling OpenAI LLM will with user defined message: [{}]", message);

        StructuredResponseCreateParams<?> params = ResponseCreateParams.builder()
                .input(message)
                .model(ChatModel.GPT_4O)
                .text(klass)
                .build();
        return openAIClient.responses().create(params);
    }
}
