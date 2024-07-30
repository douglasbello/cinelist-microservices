package com.cinelist.ms.cast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class CastApplication {
	public static void main(String[] args) {
		SpringApplication.run(CastApplication.class, args);
	}
}