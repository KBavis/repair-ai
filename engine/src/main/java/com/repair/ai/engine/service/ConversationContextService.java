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
     *       - existing session ID
     * @return
     *      - corresponding ConversationContext
     */
    public ConversationContext getConversationContext(String sessionId) {
            return repository.findBySessionId(sessionId)
                    .orElse(createConversationContext(sessionId)); // create new ConversationContext if one isn't already created
    }

    /**
     * Create a new conversation context
     *
     * @param sessionId
     *          - session ID
     * @return
     *          - created ConversationContext
     *
     */
    public ConversationContext createConversationContext(String sessionId) {
        ConversationContext newContext = new ConversationContext(sessionId);
        return repository.save(newContext);
    }

    /**
     * Update an existing conversation context
     *
     * @param updatedContext
     *          - updated conversation context
     * @return
     *          - persisted conversation context
     */
    public ConversationContext updateConversationContext(ConversationContext updatedContext) {
        return repository.save(updatedContext);
    }
}
