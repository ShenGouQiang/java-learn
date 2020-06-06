package com.gouqiang.shen.service.impl;

import com.gouqiang.shen.domain.Person;
import com.gouqiang.shen.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 *  Redis 缓存实现
 * @author shengouqiang
 */
@Service
@Slf4j
public class RedisCacheServiceImpl implements CacheService {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    @Cacheable(cacheNames = "testCache",key ="#key")
    public Person getCache(String key) {
        Person p = new Person();
        p.setAge(18);
        p.setIdCard("21536125613131481563161");
        p.setName("HaHa");
        p.setSex("M");
        log.info("starting get the cache");
       return p;
    }

    @Override
    @CachePut(cacheNames = "testCache",key = "#key")
    public Person updateCache(String key){
        Person p = new Person();
        p.setAge(18);
        p.setIdCard("21536125613131481563161");
        p.setName("HaHa");
        p.setSex("F");
        log.info("starting get the cache");
        return p;
    }

    @Override
    @CacheEvict(cacheNames = "testCache",key = "#key")
    public void deleteCache(String key) {
       log.info("key delete success");
    }

    @Override
    public Boolean setCache(String key, String value) {
        log.info("starting set the cache");
        return Boolean.TRUE;
    }
}
