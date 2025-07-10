package com.repair.ai.engine.repository;

import com.repair.ai.engine.models.entity.ConversationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationContextRepository extends JpaRepository<ConversationContext, Long> {

    ConversationContext findBySessionId(String sessionId);
}
