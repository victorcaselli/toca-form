package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.dto.VisitorDTO;
import br.com.casellisoftware.tocaform.entities.AppConfiguration;
import br.com.casellisoftware.tocaform.services.ConfigurationService;
import br.com.casellisoftware.tocaform.services.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;
    private final ConfigurationService configurationService;

    @GetMapping
    public ResponseEntity<List<VisitorDTO>> findAll(){
        return ResponseEntity.ok().body(visitorService.findAll());
    }

    @PostMapping
    public ResponseEntity<VisitorDTO> save(@RequestBody VisitorDTO visitorDTO){

        //TODO - Change to better response
        AppConfiguration config = configurationService.findConfiguration();
        System.out.println(config);
        System.out.println(config.getState());
        System.out.println(config.getVisitorsScreen());
        if(!config.getState() || (config.getState() && !config.getVisitorsScreen())){
            return ResponseEntity.badRequest().build();
        }

        visitorDTO = visitorService.save(visitorDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(visitorDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(visitorDTO);
    }
}
