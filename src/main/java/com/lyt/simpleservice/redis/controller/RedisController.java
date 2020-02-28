package com.lyt.simpleservice.redis.controller;

import com.lyt.simpleservice.redis.client.RedisClient;
import com.lyt.simpleservice.redis.model.SimpleInfo;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class RedisController {

    @Autowired
    private RedisClient<SimpleInfo> redisClient;

    @RequestMapping("/v1/redis/{key}")
    public SimpleInfo queryKey(@PathVariable String key) {
        return redisClient.get(key);
    }

    @PostMapping("/v1/redis/{key}")
    public boolean insertUsers(@PathVariable String key,
                               @RequestParam long timeout,
                               @RequestBody SimpleInfo simpleInfo
    ) {
        log.info("insert key {} value {}", key, simpleInfo);
        return redisClient.set(key, simpleInfo, timeout);
    }

    @DeleteMapping("/v1/redis/{key}")
    public boolean removeKey(@PathVariable String key) {
        log.warn("remove key {}",key);
        return redisClient.delete(key);
    }
}
