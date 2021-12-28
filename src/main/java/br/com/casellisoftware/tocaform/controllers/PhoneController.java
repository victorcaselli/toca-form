package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.entities.Phone;
import br.com.casellisoftware.tocaform.services.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.casellisoftware.tocaform.util.UriUtil.getUri;

//TODO - Change Phone to PhoneDto
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> findAll(){
        return ResponseEntity.ok().body(phoneService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Phone> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(phoneService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Phone> save(@RequestBody Phone phone){
        phone = phoneService.save(phone);
        return ResponseEntity.created(getUri(phone.getId())).body(phone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        phoneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
