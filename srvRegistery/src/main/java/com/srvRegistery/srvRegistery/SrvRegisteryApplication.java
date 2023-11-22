package com.srvRegistery.srvRegistery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SrvRegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrvRegisteryApplication.class, args);
	}

}
