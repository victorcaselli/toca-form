package br.com.casellisoftware.tocaform.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * Main configuration of the system beans
 *
 * @author V. D. Caselli
 * @since 1.0
 */

@Configuration
public class AppConfig {

    /**
     * Basic configuration of the global model mapper component
     * @return ModelMapper
     */

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
