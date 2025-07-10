package com.repair.ai.engine.models.entity;

import com.repair.ai.engine.models.enums.ConversationState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "conversation_context")
@Data
public class ConversationContext {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id")
    private String sessionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_state")
    private ConversationState currentState;

    @Column(name = "problem_category")
    private String category;

    @Column(name = "conversation_history_json")
    private String conversationHistoryJson;

    @Column(name = "question_count")
    private Integer questionCount;

    @Column(name = "safety_check_passed")
    private Boolean safetyCheckPassed = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public ConversationContext() {
        this.currentState = ConversationState.INITIAL_ASSESSMENT;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    public ConversationContext(String sessionId) {
        this();
        this.sessionId = sessionId;
    }



    //TODO: Implement updates to conversation history
}
