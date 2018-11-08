package com.java56;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.java56.dao")
public class SpringBootCrudApplication {
	//启动
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}
}
