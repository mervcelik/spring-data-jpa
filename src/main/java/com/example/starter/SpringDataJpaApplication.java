package com.example.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.configuration.GlobalProperties;

@EnableConfigurationProperties(value=GlobalProperties.class)
@EnableJpaRepositories(basePackages = {"com.example"})
@ComponentScan(basePackages =  {"com.example"})
@EntityScan(basePackages =  {"com.example"})
@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
