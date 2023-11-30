package com.pad.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class PadApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadApplication.class, args);
	}

}
