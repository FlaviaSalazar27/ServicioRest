package com.Puma.AnfitrionPuma;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class CargadoBasedeDatos {
    @Bean
    CommandLineRunner initDatabase(RepositorioAnfitrion repository) {
        return args -> {
            log.info("Preloading " + repository.save(new AnfitrionP("Gabriela Salazar", "gabriela@gmail.com",76524989,"6795884")));
            log.info("Preloading " + repository.save(new AnfitrionP("Nicol Sanabria", "nicol@gmail.com",7846552,"1236559")));
        };
    }
}
