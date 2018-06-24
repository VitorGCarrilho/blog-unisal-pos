package br.unisal.blogunisal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Vitor Carrilho - 24/06/2018
 *
 */
@Configuration 
public class CORSConfig implements  WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {		
		registry.addMapping("/**") 
			.allowedOrigins("*") 
			.allowedMethods("GET", "POST", "PATCH", "DELETE", "PUT", "OPTIONS") 
        	.allowedHeaders("X-Requested-With,Content-Type,Accept,Origin");
	}
}
