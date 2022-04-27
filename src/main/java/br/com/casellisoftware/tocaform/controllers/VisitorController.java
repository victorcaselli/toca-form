package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.dto.VisitorDTORequest;
import br.com.casellisoftware.tocaform.dto.VisitorDTOResponse;
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
    public ResponseEntity<List<VisitorDTOResponse>> findAll(){
        return ResponseEntity.ok().body(visitorService.findAll());
    }

    @PostMapping
    public ResponseEntity<VisitorDTORequest> save(@RequestBody VisitorDTORequest visitorDTORequest){

        //TODO - Change to better response
        AppConfiguration config = configurationService.findConfiguration();
        if(!config.getState() || (config.getState() && !config.getVisitorsScreen())){
            return ResponseEntity.badRequest().build();
        }

        visitorDTORequest = visitorService.save(visitorDTORequest);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(visitorDTORequest.getId())
                .toUri();

        return ResponseEntity.created(uri).body(visitorDTORequest);
    }


    @GetMapping("disciple/{id}")
    public ResponseEntity<Void> createDiscipleFromVisitor(@PathVariable(name = "id") Long visitorsId){
        visitorService.createDiscipleFromVisitor(visitorsId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long visitorsId){
        visitorService.deleteById(visitorsId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<VisitorDTOResponse>> findAllByParams(
            @RequestParam(value = "name", required = false) String name
    ){

        return ResponseEntity.ok().body(visitorService.findAllByParams(name));
    }
}
