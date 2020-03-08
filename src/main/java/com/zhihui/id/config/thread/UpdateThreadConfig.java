package com.zhihui.id.config.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author LDZ
 * @date 2020-03-08 22:42
 */
@Configuration
public class UpdateThreadConfig {

    @Bean(name = "update", initMethod = "initialize", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(Integer.MAX_VALUE);
        //2分钟
        threadPoolTaskExecutor.setKeepAliveSeconds(60);
        threadPoolTaskExecutor.setThreadNamePrefix("Thread-Segment-Update-");
        return threadPoolTaskExecutor;
    }

}
