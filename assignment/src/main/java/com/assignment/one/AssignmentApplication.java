package com.assignment.one;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Bean("assignmentExecuter")
	public TaskExecutor asynExecuter()
	{
		ThreadPoolTaskExecutor executer  = new ThreadPoolTaskExecutor();
		executer.setCorePoolSize(20);
		executer.setMaxPoolSize(20);
		executer.setQueueCapacity(1000);
		executer.setThreadNamePrefix("assignmentthread-");
		executer.initialize();
		return executer;
	}
}