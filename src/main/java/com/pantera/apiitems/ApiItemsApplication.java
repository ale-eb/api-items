package com.pantera.apiitems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiItemsApplication.class, args);
	}

}
