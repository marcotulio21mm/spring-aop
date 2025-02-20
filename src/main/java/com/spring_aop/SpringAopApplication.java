package com.spring_aop;

import com.spring_aop.dummy.DummyService;
import com.spring_aop.hello.HelloService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(HelloService helloService, DummyService dummyService) {
		return args -> {
			helloService.hello();
			dummyService.dummy();
		};
	}

}
