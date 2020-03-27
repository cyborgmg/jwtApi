package com.jwtApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jwtApi.api.entity.User;
import com.jwtApi.api.enums.ProfileEnum;
import com.jwtApi.api.service.UserService;

@SpringBootApplication
public class jwtApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(jwtApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserService userService, PasswordEncoder passwordEncoder) {
		return args -> {
				initUsers(userService, passwordEncoder);
			};
	}
	
	private void initUsers(UserService userService, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("admin@helpdesk.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		
		User find = userService.findByEmail("admin@helpdesk.com");
		if(find == null ) {
			userService.createOrUpdate(admin);
		}
	}
}
