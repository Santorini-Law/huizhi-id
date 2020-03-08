package com.zhihui.id.config.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 线程池
 *
 * @author LDZ
 * @date 2020-03-08 15:42
 */
@Configuration
public class ThreadPoolConfig {


    @Bean(name = "default", initMethod = "initialize", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(20);
        threadPoolTaskExecutor.setMaxPoolSize(200);
        //最大队列数量
        threadPoolTaskExecutor.setQueueCapacity(500);
        //2分钟
        threadPoolTaskExecutor.setKeepAliveSeconds(120);
        threadPoolTaskExecutor.setThreadNamePrefix("executor-thread-");
        return threadPoolTaskExecutor;
    }
}
