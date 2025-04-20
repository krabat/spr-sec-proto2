package com.example.sprsecproto2.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain( HttpSecurity http ) throws Exception {
		String[] unprotected = { "/", "/favicon.ico", "/error" };
		http
			.authorizeHttpRequests( authorize -> authorize
					.requestMatchers( unprotected ).permitAll()
					
//					.anyRequest().permitAll() )			//UNCOMMENT TO ALLOW ALL
					.anyRequest().authenticated() )		//UNCOMMENT TO SECURE ALL
			
			.csrf( csrf -> csrf.ignoringRequestMatchers( "/store-console/**" ) )
			.formLogin( Customizer.withDefaults() );
		return http.build();
	}
	
	
	@Bean
	@SuppressWarnings( "deprecation" )
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
			.username( "user" )
			.password( "password" )
			.roles( "USER" )
			.build();
		return new InMemoryUserDetailsManager( user );
	}
	
}
