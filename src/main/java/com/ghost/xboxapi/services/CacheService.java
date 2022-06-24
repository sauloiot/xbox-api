package com.ghost.xboxapi.services;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CacheService.class);
    private static Map<String, String> cache = new HashMap<>(); // GLOBAL VARIABLE

    public static Map<String, String> getAllCache() {
        return cache;
    }

    public static String getCache(String key) {
        return cache.get(key);
    }

    // Put data in global cache variable
    public static void putCache(String key, String value) {
        cache.put(key, value);
    }

    public static Integer getIntegerCache(String key) {
        return Integer.parseInt((getCache(key) == null || getCache(key).isEmpty() || getCache(key).isBlank()) ? "0" : getCache(key));
    }

    public static void putIntegerCache(String key, Integer value) {
        putCache(key, Integer.toString(value));
    }

    public void initGlobalCache () {
//        putCache(GlobalCacheEnum.HAS_NEW_EMAILS.getKey(), GlobalCacheEnum.HAS_NEW_EMAILS.getValue());

        LOGGER.info(String.valueOf(getAllCache()));
    }
}
