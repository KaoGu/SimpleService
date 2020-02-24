package com.lyt.simpleservice.redis.client;

import com.lyt.simpleservice.util.json.JsonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisClient<V> {
    private static final Log LOGGER = LogFactory.getLog(RedisClient.class);

    private RedisTemplate<String, String> redisTemplate;

    private final String domainName;

    private final Class<V> classValue;

    public RedisClient(RedisTemplate<String, String> redisTemplate, String domainName, Class<V> classValue) {
        this.redisTemplate = redisTemplate;
        this.domainName = domainName;
        this.classValue = classValue;
    }

    public V get(final String key) {
        String result = redisTemplate.opsForValue().get(getDomainKey(key));
        return JsonUtil.string2Obj(result, classValue);
    }

    private String getDomainKey(String key) {
        return domainName + ":" + key;
    }

    public boolean set(final String key, V value, long timeoutSeconds) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(getDomainKey(key),
                    JsonUtil.obj2String(value),
                    timeoutSeconds, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            LOGGER.error("occur exception {}", e);
        }
        return result;
    }

    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(getDomainKey(key));
            result = true;
        } catch (Exception e) {
            LOGGER.error("occur exception {}", e);
        }
        return result;
    }
}
