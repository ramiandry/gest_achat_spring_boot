package com.gest_achats.gest_achat;

import com.gest_achats.gest_achat.service.FileStorageService;
import com.gest_achats.gest_achat.service.FileStorageServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GestAchatApplication{


	public static void main(String[] args) {
		SpringApplication.run(GestAchatApplication.class, args);
	}

}
