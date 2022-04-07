package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.entities.AppConfiguration;
import br.com.casellisoftware.tocaform.services.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/configuration")
public class ConfigurationController {

    private final ConfigurationService configurationService;



    @PostMapping("/screen/visitors")
    public ResponseEntity<Void> configure(@RequestBody AppConfiguration appConfiguration){
        configurationService.save(appConfiguration);

        return ResponseEntity.noContent().build();
    }
}
