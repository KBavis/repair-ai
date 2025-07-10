package com.repair.ai.engine.service;

import com.repair.ai.engine.models.entity.ConversationContext;
import com.repair.ai.engine.repository.ConversationContextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationContextService {

    @Autowired
    private ConversationContextRepository repository;


    /**
     * Retrieve ConversationContext based on session ID
     *
     * @param sessionId
     *          - existing session ID
     * @return
     *          - corresponding ConversationContext
     */
    public ConversationContext getConversationContext(String sessionId) {
            return repository.findBySessionId(sessionId);
    }
}
