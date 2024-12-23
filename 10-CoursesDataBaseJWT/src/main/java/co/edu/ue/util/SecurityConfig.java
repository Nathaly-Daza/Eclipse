package co.edu.ue.util;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {	
	
	AuthenticationManager auth;
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration conf) throws Exception {
		auth= conf.getAuthenticationManager();		
		return auth;
	}
	
	@Bean
	public JdbcUserDetailsManager usersDetailsJdbc() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/user_security_encr");
		ds.setUsername("root");
		ds.setPassword("");
		
		JdbcUserDetailsManager jdbcDetails=new JdbcUserDetailsManager(ds);
		
		jdbcDetails.setUsersByUsernameQuery("select use_user, use_pass, use_status"
           	+ " from users where use_user=? and use_status=1");
			
		jdbcDetails.setAuthoritiesByUsernameQuery("SELECT use_user,rol FROM roles "
				+ "WHERE use_user = ?");


		printUsers(ds);
		return jdbcDetails;
	}
	  // Método para imprimir usuarios y roles
    private void printUsers(DriverManagerDataSource ds) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);

        // Imprimir usuarios
        List<String> users = jdbcTemplate.query("SELECT use_user FROM users", (rs, rowNum) -> rs.getString("use_user"));
        System.out.println("Usuarios en la base de datos: " + users);

        // Imprimir roles (asumiendo que deseas imprimir todos los roles)
        List<String> roles = jdbcTemplate.query("SELECT rol FROM roles", (rs, rowNum) -> rs.getString("rol"));
        System.out.println("Roles en la base de datos: " + roles);
    }
	
    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(cus->cus.disable())
		.authorizeHttpRequests(aut->
			aut.requestMatchers(HttpMethod.POST,"/api/course").hasRole("ADMINS")
			//.requestMatchers(HttpMethod.DELETE,"/datos/**").hasRole("ADMINS")
			.requestMatchers(HttpMethod.GET,"/api/courses").hasAnyRole("ADMINS","USERS")
			.requestMatchers(HttpMethod.GET,"/api/courses-id").hasRole("ADMINS")		
			.anyRequest().permitAll()
			)
		.addFilter(new AuthorizationFilterJWT(auth));
		return http.build();
	}

}
