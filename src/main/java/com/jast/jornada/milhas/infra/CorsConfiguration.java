package com.jast.jornada.milhas.infra;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfiguration implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").
            allowedOrigins("*")
            .allowedMethods("GET","POST","PUT","DELETE","OPTIONS","HEAD","TRACE","CONNECT");

    }
}
