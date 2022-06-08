package com.rerollyourbody.gymbro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GymbroApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymbroApplication.class, args);
	}

}
