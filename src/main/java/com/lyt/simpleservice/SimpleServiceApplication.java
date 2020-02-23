package com.lyt.simpleservice;

import com.lyt.simpleservice.util.BeanUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimpleServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SimpleServiceApplication.class, args);
		BeanUtil.applicationContext = configurableApplicationContext;
	}

}
