package com.ccniit.graduation.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class SpringMVCConfig {

	@Bean(name = "mvcTaskExecutor")
	public ThreadPoolTaskExecutor mvcTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setQueueCapacity(100);
		executor.setMaxPoolSize(25);
		return executor;

	}

}
