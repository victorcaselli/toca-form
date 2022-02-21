package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.entities.EnumerationEntity;
import br.com.casellisoftware.tocaform.enums.*;
import br.com.casellisoftware.tocaform.services.EnumerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enums")
@RequiredArgsConstructor
@PreAuthorize(value = "hasAnyRole('ADMIN', 'PASTOR', 'LEADER')")
public class EnumerationController {

    private final EnumerationService service;

    @GetMapping
    public ResponseEntity<List<EnumerationEntity>> christeningStatusType(
            @RequestParam(required = false) Boolean christening,
            @RequestParam(required = false) Boolean church,
            @RequestParam(required = false) Boolean decision,
            @RequestParam(required = false) Boolean phone,
            @RequestParam(required = false) Boolean whatsapp
    ){
        if(christening != null && christening) {
            return ResponseEntity.ok().body(service.getAll(ChristeningStatusType.values()));
        }else if(church != null && church) {
            return ResponseEntity.ok().body(service.getAll(ChurchStatusType.values()));
        }else if(decision != null && decision) {
            return ResponseEntity.ok().body(service.getAll(DecisionType.values()));
        }else if(phone != null && phone) {
            return ResponseEntity.ok().body(service.getAll(PhoneType.values()));
        }else if(whatsapp != null && whatsapp){
            return ResponseEntity.ok().body(service.getAll(WhatsappStatusType.values()));
        }

        return ResponseEntity.noContent().build();
    }
}
