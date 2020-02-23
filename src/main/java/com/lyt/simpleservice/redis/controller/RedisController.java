package com.lyt.simpleservice.redis.controller;

import com.lyt.simpleservice.redis.client.RedisClient;
import com.lyt.simpleservice.redis.model.SimpleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
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
        return redisClient.set(key, simpleInfo, timeout);
    }

    @DeleteMapping("/v1/redis/{key}")
    public boolean removeKey(@PathVariable String key) {
        return redisClient.delete(key);
    }
}
