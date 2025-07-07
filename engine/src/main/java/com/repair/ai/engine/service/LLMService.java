package com.repair.ai.engine.service;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LLMService {

    //TODO: Move this to config
    @Autowired
    private Dotenv dotenv;


    public Response testingApiCallToOpenAi() {

        // TODO: Move this to config
        OpenAIClient openAIClient = OpenAIOkHttpClient.builder()
                .apiKey(dotenv.get("OPENAI_API_KEY"))
                .build();

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input("Say this is a test and hello to RepairAI")
                .model(ChatModel.GPT_3_5_TURBO)
                .build();

        return openAIClient.responses().create(params);
    }
}
