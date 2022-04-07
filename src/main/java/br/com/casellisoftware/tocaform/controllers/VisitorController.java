package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.dto.VisitorDTO;
import br.com.casellisoftware.tocaform.services.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/visitors")
public class VisitorController {

    private final VisitorService visitorService;

    @GetMapping
    public ResponseEntity<List<VisitorDTO>> findAll(){
        return ResponseEntity.ok().body(visitorService.findAll());
    }

    @PostMapping
    public ResponseEntity<VisitorDTO> save(@RequestBody VisitorDTO visitorDTO){
        visitorDTO = visitorService.save(visitorDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(visitorDTO.getId())
                .toUri();

        return ResponseEntity.created(uri).body(visitorDTO);
    }
}
