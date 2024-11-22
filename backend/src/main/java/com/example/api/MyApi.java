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
        elementos.add(new Datos(1, "Elemento 1", "Descripción del elemento 1"));
        elementos.add(new Datos(2, "Elemento 2", "Descripción del elemento 2"));
        elementos.add(new Datos(3, "Elemento 3", "Descripción del elemento 3"));
        
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
