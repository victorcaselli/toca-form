package br.com.casellisoftware.tocaform.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfigurationSource;

@RequiredArgsConstructor
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    private final JwtTokenStore tokenStore;
    private final CorsConfigurationSource corsConfigurationSource;



    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/api/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/disciples").hasAnyRole("ADMIN", "DISCIPLE_RECORDER", "PASTOR")
                .antMatchers(HttpMethod.GET, "/api/disciples/**").hasAnyRole("ADMIN", "PASTOR", "DISCIPLE_FINDER")
                .antMatchers(HttpMethod.DELETE, "/api/disciples/{id}").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/disciples/all").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/visitors").permitAll()
                .antMatchers(HttpMethod.GET, "/api/visitors/**").hasAnyRole("VISITOR_FINDER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/enums/visitors").permitAll()
                .anyRequest().authenticated();

        http.cors().configurationSource(corsConfigurationSource);
    }



}
