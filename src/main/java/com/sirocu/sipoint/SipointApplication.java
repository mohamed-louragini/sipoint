package com.sirocu.sipoint;

import com.sirocu.sipoint.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableJpaAuditing
@SpringBootApplication
public class SipointApplication {

	public static void main(String[] args) {
		SpringApplication.run(SipointApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRepository role) {
		return args -> {
//			RequestContext.setUserId(0L);
//			var userRole = new RoleEntity();
//			userRole.setName(Authority.USER.name());
//			userRole.setAuthorities(Authority.USER);
//			role.save(userRole);
//
//			var adminRole = new RoleEntity();
//			adminRole.setName(Authority.ADMIN.name());
//			adminRole.setAuthorities(Authority.ADMIN);
//			role.save(adminRole);
//			RequestContext.start();
		};
	}
}
//TODO continue on 5.01.00