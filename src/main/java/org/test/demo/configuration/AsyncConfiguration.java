package org.test.demo.configuration;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {
	
	final static Logger logger = LoggerFactory.getLogger(AsyncConfiguration.class);
	private int CORE_POOL_SIZE = 5;
	private int MAX_POOL_SIZE = 10;
	private int QUEUE_CAPACITY = 10;
	
	@Override
	public Executor getAsyncExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(CORE_POOL_SIZE);
            executor.setMaxPoolSize(MAX_POOL_SIZE);
            executor.setQueueCapacity(QUEUE_CAPACITY);
            executor.initialize();
            return executor;
	}
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		AsyncUncaughtExceptionHandler handler = new AsyncUncaughtExceptionHandler() {
			
			@Override
			public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
				logger.debug("Caught exception " + arg0.getMessage());
				logger.debug("Class name " + arg1.getClass().getName() + ", Method name " + arg1.getName());
				for (int i=0;i<arg2.length;i++) {
					logger.debug("Argument " + i + " " + arg2[i]);
				}
			}
		};
		return handler;
	}
} 
