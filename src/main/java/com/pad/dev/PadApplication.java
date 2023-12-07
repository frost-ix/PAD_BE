package com.pad.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/proxy")
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class PadApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadApplication.class, args);
		System.out.println("Server running... PORT : 8800");
	}

}
