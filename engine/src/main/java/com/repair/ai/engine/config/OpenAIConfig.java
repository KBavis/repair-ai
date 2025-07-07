package com.repair.ai.engine.config;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Autowired
    private Dotenv dotenv;

    @Bean
    public OpenAIClient openAIClient() {

        return OpenAIOkHttpClient.builder()
                .apiKey(dotenv.get("OPENAI_API_KEY"))
                .build();
    }
}
