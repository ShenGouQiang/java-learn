package com.gouqiang.shen.controller;

import com.alibaba.fastjson.JSONObject;
import com.gouqiang.shen.domain.Person;
import com.gouqiang.shen.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/server/cache/api/")
public class CacheController {

    @Resource
    private CacheService cacheService;

    @GetMapping("info")
    public Person getCache(@RequestParam("key") String key){
        Person p = cacheService.getCache(key);
        return p;
    }

    @GetMapping("modify")
    public Person upateCache(@RequestParam("key") String key){
        Person p = cacheService.updateCache(key);
        return p;
    }

    @GetMapping("delete")
    public String deleteCache(@RequestParam("key") String key){
        cacheService.deleteCache(key);
        JSONObject obj = new JSONObject();
        obj.put("code","0");
        return obj.toString();
    }
}
