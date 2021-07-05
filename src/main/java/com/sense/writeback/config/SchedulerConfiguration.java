package com.sense.writeback.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executor;

@Configuration
public class SchedulerConfiguration extends AsyncConfigurerSupport {
    private final Integer connectionPoolSize;

    public SchedulerConfiguration(@Value("${spring.datasource.maximum-pool-size}") Integer connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(connectionPoolSize);
        executor.setMaxPoolSize(42);
        executor.setQueueCapacity(11);
        executor.setThreadNamePrefix("TenantAwareTaskExecutor-");
        executor.setTaskDecorator(new TenantAwareTaskDecorator());
        executor.initialize();

        return executor;
    }

    @Bean
    public Scheduler jdbcScheduler() {
        return Schedulers.fromExecutor(getAsyncExecutor());
    }

}