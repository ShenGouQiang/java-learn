package com.gouqiang.shen.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


/**
 * @author shengouqiang
 * @date 2020/4/1
 */
@ConfigurationProperties(prefix = "cachename-ttl-config")
@Data
@Configuration
@ConditionalOnProperty(prefix = "cachename-ttl-config",value = "config",havingValue = "true")
public class CacheNameTtlConfig {
    private Map<String, Long> ttlConfigMap;
}