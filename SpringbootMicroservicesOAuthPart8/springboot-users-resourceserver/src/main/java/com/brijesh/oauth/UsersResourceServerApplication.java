package com.brijesh.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UsersResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersResourceServerApplication.class, args);
	}

}
