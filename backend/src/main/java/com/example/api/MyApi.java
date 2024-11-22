package com.example.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.modelo.Datos;
import java.util.List;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/mostrar")
public class MyApi {
    @GetMapping("/elementos")
    public List<Datos> getData() {
        List<Datos> elementos = new ArrayList<>();
        elementos.add(new Datos(1, "Michelle", "Edad: 22"));
        elementos.add(new Datos(2, "Oscar", "Edad: 31"));
        elementos.add(new Datos(3, "Elisa", "Edad: 21"));
        
        return elementos;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8081");
            }
        };
    }
}
