package com.lyt.simpleservice.config;

import com.lyt.simpleservice.redis.client.RedisClient;
import com.lyt.simpleservice.redis.model.SimpleInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@Slf4j
public class SimpleServiceConfigration {

    @Value("${simpleservice.redis.name}")
    private String rdbName;

    @Autowired
    RedisTemplate<String, String> simpleInfoRedisTemplate;

    @Bean("mySimpleInfoRedisClient")
    public RedisClient<SimpleInfo> redisTemplate() {
        log.info("init bean mySimpleInfoRedisClient" + simpleInfoRedisTemplate);
        return new RedisClient<>(simpleInfoRedisTemplate, rdbName + ":simpleinfo", SimpleInfo.class);
    }
}
