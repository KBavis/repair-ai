package com.repair.ai.engine.models.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Parent class to contain duplicate functionality across various types of AI Response
 *
 * TODO: Add other generic information
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AIResponse {
    private LocalDateTime responseTime;
}
