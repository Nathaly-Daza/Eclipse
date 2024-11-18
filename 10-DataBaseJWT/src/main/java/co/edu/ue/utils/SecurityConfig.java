package co.edu.ue.utils;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class SecurityConfig {
	/*public InMemoryUserDetailsManager userManager() {
		List<UserDetails> users=List.of(
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
	}*/
	AuthenticationManager auth;
	
	public AuthenticationManager authManager(AuthenticationConfiguration conf) {
		try {
			auth = conf.getAuthenticationManager();
		} catch (Exception e) {
			System.out.println(" "+e.getMessage());
			e.printStackTrace();
		}
		return auth;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(cus->cus.disable())
		.authorizeHttpRequests(aut->
			aut.requestMatchers(HttpMethod.POST,"/api-courses/course").hasAnyRole("GUEST")
			//.requestMatchers(HttpMethod.DELETE,"/datos/**").hasAnyRole("ADMINS","OTHER")
			.requestMatchers(HttpMethod.GET,"/api-courses/courses-all").hasAnyRole("MAST")
			.requestMatchers(HttpMethod.GET,"/api-courses/*").authenticated()			
			
			)
		.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
	
}
