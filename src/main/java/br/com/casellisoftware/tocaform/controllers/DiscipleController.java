package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.dto.DiscipleDTOResponse;
import br.com.casellisoftware.tocaform.entities.Disciple;
import br.com.casellisoftware.tocaform.services.DiscipleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.casellisoftware.tocaform.util.UriUtil.getUri;
//TODO - Change Disciple to DiscipleDto
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/disciples")
public class DiscipleController {

    private final DiscipleService discipleService;

    @GetMapping
    public ResponseEntity<List<DiscipleDTOResponse>> findAll(){
        return ResponseEntity.ok().body(discipleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscipleDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(discipleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Disciple> save(@RequestBody Disciple disciple){
        disciple = discipleService.save(disciple);
        return ResponseEntity.created(getUri(disciple.getId())).body(disciple);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        discipleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<DiscipleDTOResponse>> findAllByParams(
            @RequestParam(value = "name", required = false) String name
            ){

        return ResponseEntity.ok().body(discipleService.findAllByParams(name));
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll(){
        this.discipleService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
