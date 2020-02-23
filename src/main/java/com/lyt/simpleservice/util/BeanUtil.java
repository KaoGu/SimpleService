package com.lyt.simpleservice.util;

import org.springframework.context.ConfigurableApplicationContext;

public class BeanUtil {
    //将管理上下文的applicationContext设置成静态变量，供全局调用
    public static ConfigurableApplicationContext applicationContext;

    public static <T> T getBean(Class<T> tclass){
        return applicationContext.getBean(tclass);
    }
}
