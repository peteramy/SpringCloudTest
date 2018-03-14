package com.zuulService;

import com.zuulService.filter.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

@EnableZuulProxy
public class ZuulServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}

    @Bean
    MyFilter myFilter(){
        return new MyFilter();
    }
}
