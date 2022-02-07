package br.com.casellisoftware.tocaform.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


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



    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
