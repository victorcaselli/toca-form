package br.com.casellisoftware.tocaform.controllers.exceptions;

import br.com.casellisoftware.tocaform.controllers.exceptions.model.StandardError;
import br.com.casellisoftware.tocaform.services.exceptions.DiscipleNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {



    @ExceptionHandler(DiscipleNotFoundException.class)
    public ResponseEntity<StandardError> discipleNotFound(DiscipleNotFoundException dnfe, HttpServletRequest request){
        return ResponseEntity.ok().body(StandardError.builder()
                .timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime())
                .error("Teste")
                .message("Teste message")
                .path(request.getServletPath())
                .build());
    }
}
