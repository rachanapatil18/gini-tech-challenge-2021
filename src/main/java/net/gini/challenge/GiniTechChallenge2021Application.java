package net.gini.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "net.gini.challenge.*")
public class GiniTechChallenge2021Application {

	public static void main(String[] args) {
		SpringApplication.run(GiniTechChallenge2021Application.class, args);
	}
	
   @Bean
   public RestTemplate getRestTemplate() {
      return new RestTemplate();
   }

}
