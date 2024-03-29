package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mapper") //扫描接口
public class SpringbootApplication {
	public static void main(String[] args) {
		System.out.println(123);
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
