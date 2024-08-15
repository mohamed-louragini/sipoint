package com.sirocu.sipoint.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class CacheConfig {

    @Bean(name = { "userloginCache" })
    public CacheStore<String, Integer> userCache() {
        return new CacheStore<>(900, SECONDS);
    }
}
