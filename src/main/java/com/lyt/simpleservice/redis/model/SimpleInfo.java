package com.lyt.simpleservice.redis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SimpleInfo {
    private String key;
    private String value;
}
