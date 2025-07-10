package com.repair.ai.engine.models.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//TODO: Add other necessary attributes

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMessage {
    private String message;
    private LocalDateTime createdAt;
}
