package com.sugmya.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sugmya.view.Login;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.sugmya"})
@EntityScan(basePackages = {"com.sugmya"})
public class SugmyaApplication{
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext c=new SpringApplicationBuilder(SugmyaApplication.class).headless(false).run(args);
		Login login = c.getBean(Login.class);
		login.setVisible(true);
		
	}
}
