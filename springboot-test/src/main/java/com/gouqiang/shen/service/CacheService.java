package com.gouqiang.shen.service;

import com.gouqiang.shen.domain.Person;

/**
 * 缓存模型
 */
public interface CacheService {

    Person getCache(String key);

    Boolean setCache(String key,String value);

    Person updateCache(String key);

    void deleteCache(String key);
}
