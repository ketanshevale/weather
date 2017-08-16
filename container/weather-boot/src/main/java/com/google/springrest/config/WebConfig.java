package com.google.springrest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//to enable web configuration use, it will understand HTTP request, session, etc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    
    
    //added
	@Override
	public void addCorsMappings(CorsRegistry registry){
		registry
		.addMapping("/weather/api")
		.allowedOrigins("*")
		.allowedHeaders("*")
		.allowedMethods("GET", "PUT", "POST", "DELETE", "OPTION", "PATCH");
	}
}	