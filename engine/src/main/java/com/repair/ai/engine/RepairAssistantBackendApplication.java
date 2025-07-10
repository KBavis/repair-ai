package com.repair.ai.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.repair.ai.engine.repository")
@EntityScan(basePackages = "com.repair.ai.engine.models.entity")
public class RepairAssistantBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepairAssistantBackendApplication.class, args);
	}

}
