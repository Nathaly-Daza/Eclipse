package co.edu.ue.util;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userManager() {
		List<UserDetails> users =List.of(
				User
				.withUsername("avanzado")
				.password("{noop}1234")
				.roles("AVAN")
				.build(),	
				User
				.withUsername("master")
				.password("{noop}1234")
				.roles("MAST")
				.build(),	
				User
				.withUsername("invitado")
				.password("{noop}1234")
				.roles("GUEST")
				.build()
				);
		return new InMemoryUserDetailsManager(users);
	}
	
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(cus->cus.disable())
		.authorizeHttpRequests(aut->
			aut.requestMatchers(HttpMethod.POST,"/api-courses/course").hasAnyRole("GUEST")
			.requestMatchers(HttpMethod.GET,"/api-courses/courses-all").hasAnyRole("MAST")
			.requestMatchers(HttpMethod.GET,"/api-courses/*").authenticated()		
			)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	

}
