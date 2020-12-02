package com.example.springtweet.springtweet.cacheconfig;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
class Config implements CachingConfigurer {

    @Bean
    @Override
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
//        GuavaCache guavaCache = new GuavaCache("timeline cache", CacheBuilder.newBuilder()
//                .expireAfterWrite(1, TimeUnit.MINUTES)
//                .build());
//        GuavaCache guavaCache1 = new GuavaCache("timelineFilter cache", CacheBuilder.newBuilder()
//                .expireAfterWrite(100, TimeUnit.SECONDS)
//                .build());
//        if (guavaCache != null) {
//            simpleCacheManager.setCaches(Arrays.asList(guavaCache));
//        } else {
//            simpleCacheManager.setCaches(Arrays.asList(guavaCache1));
//        }

        List<GuavaCache> caches = new ArrayList<GuavaCache>();
        caches.add(new GuavaCache("timeline cache",CacheBuilder.newBuilder().expireAfterWrite(1,TimeUnit.MINUTES).build()));
        caches.add(new GuavaCache("timelineFilter cache",CacheBuilder.newBuilder().expireAfterWrite(1,TimeUnit.MINUTES).build()));
        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}