package com.metallica.fsd.ui.webportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class UiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiServiceApplication.class, args);
	}
}
