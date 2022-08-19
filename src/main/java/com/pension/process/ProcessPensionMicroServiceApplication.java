package com.pension.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProcessPensionMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionMicroServiceApplication.class, args);
	}

}
