package com.kath.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"com.kath.tcs"})
public class TrafficcontrolsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficcontrolsystemApplication.class, args);
	}

}
