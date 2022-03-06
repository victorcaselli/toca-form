package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.dto.DiscipleDTOResponse;
import br.com.casellisoftware.tocaform.entities.Disciple;
import br.com.casellisoftware.tocaform.services.DiscipleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;
import static br.com.casellisoftware.tocaform.util.UriUtil.getUri;

import java.net.URI;
import java.util.List;
//TODO - Change Disciple to DiscipleDto
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/disciples")
@PreAuthorize(value = "hasAnyRole('ADMIN', 'PASTOR', 'LEADER')")
public class DiscipleController {

    private final DiscipleService discipleService;

    @GetMapping
    public ResponseEntity<List<DiscipleDTOResponse>> findAll(){
        return ResponseEntity.ok().body(discipleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciple> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(discipleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Disciple> save(@RequestBody Disciple disciple){
        disciple = discipleService.save(disciple);
        return ResponseEntity.created(getUri(disciple.getId())).body(disciple);
    }

    @PreAuthorize(value = "hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        discipleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
