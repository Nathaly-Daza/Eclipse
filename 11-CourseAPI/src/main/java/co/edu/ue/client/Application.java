package co.edu.ue.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.ue.client.controller","co.edu.ue.client.model","co.edu.ue.client.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//Registramos un RestTemplate como un bean para que se pueda inyectar en otras partes del proyecto.
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
