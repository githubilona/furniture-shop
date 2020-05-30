package com.example.furnitureshop.config;

import com.example.furnitureshop.model.Furniture;
import com.example.furnitureshop.repositories.FurnitureRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class RepositoryInitializer {
    private final FurnitureRepository furnitureRepository;

    @Autowired
    public RepositoryInitializer(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Bean
    public InitializingBean initializingBean() {
        return () -> {
            if (furnitureRepository.findAll().isEmpty()) {
                furnitureRepository.save( new Furniture("Krzesło","Opis1", "Producent1", new BigDecimal(200),11));
                furnitureRepository.save( new Furniture("Łóżko","Opis2", "Producent2", new BigDecimal(500),10));
                furnitureRepository.save( new Furniture("Stół","Opis3", "Producent3", new BigDecimal(400),9));
                furnitureRepository.save( new Furniture("Szafa","Opis4", "Producent4", new BigDecimal(800),15));
            }
        };
    }
}
