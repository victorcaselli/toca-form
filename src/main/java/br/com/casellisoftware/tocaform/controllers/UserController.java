package br.com.casellisoftware.tocaform.controllers;

import br.com.casellisoftware.tocaform.dto.UserDTO;
import br.com.casellisoftware.tocaform.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok().body(userService.save(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
