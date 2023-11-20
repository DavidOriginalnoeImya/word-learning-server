package edu.home.translationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
		basePackages = "edu.home.translationservice.proxy.translator"
)
public class TranslationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslationServiceApplication.class, args);
	}

}
