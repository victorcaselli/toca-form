package br.com.casellisoftware.tocaform.util;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class EnvironmentUtil {

    private final Environment environment;


    public String[] getEnvironment(){
        return environment.getActiveProfiles();
    }

    public boolean getProfileByName(String profileName){
        return Arrays.asList(environment.getActiveProfiles()).contains(profileName);
    }
}
