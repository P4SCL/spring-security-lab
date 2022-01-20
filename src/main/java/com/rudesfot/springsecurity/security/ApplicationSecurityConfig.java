package com.rudesfot.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.rudesfot.springsecurity.security.Enum_Role.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/","index","/css/*","/js/*").permitAll()
			.antMatchers("/api/**").hasRole(STUDENT.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
		UserDetails pascal = User.builder()
								 .username("pascal")
								 .password(passwordEncoder.encode("12345"))
								 .roles(ADMIN.name())
								 .build();	
		
		
		
		UserDetails nefi = User.builder()
				 .username("nefi")
				 .password(passwordEncoder.encode("12345"))
				 .roles(STUDENT.name())
				 .build();	
		
		System.out.println("roles pascal "+ADMIN.name());
		System.out.println("roles nefi "+STUDENT.name());
		
		return new InMemoryUserDetailsManager(pascal,nefi);
	}
	
	
}
