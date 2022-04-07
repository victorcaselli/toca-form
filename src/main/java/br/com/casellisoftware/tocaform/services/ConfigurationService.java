package br.com.casellisoftware.tocaform.services;


import br.com.casellisoftware.tocaform.entities.AppConfiguration;
import br.com.casellisoftware.tocaform.repositories.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConfigurationService {


    private final ConfigurationRepository configurationRepository;


    @Transactional
    public void save(AppConfiguration configuration){
        Optional<AppConfiguration> old = configurationRepository.findByState(true);

        old.ifPresent(appConfiguration -> appConfiguration.setState(false));

        AppConfiguration newConfig = new AppConfiguration();
        newConfig.setState(true);
        newConfig.setUpdatedAt(LocalDateTime.now());
        newConfig.setVisitorsScreen(configuration.getVisitorsScreen());

        configurationRepository.save(newConfig);
    }

    @Transactional(readOnly = true)
    public AppConfiguration findConfiguration(){
        return configurationRepository.findByState(true)
                .orElse(AppConfiguration.builder()
                        .state(false)
                        .build());
    }
}
