package br.com.casellisoftware.tocaform.controllers.exceptions;

import br.com.casellisoftware.tocaform.controllers.exceptions.model.StandardError;
import br.com.casellisoftware.tocaform.services.exceptions.DiscipleNotFoundException;
import static org.springframework.http.HttpStatus.*;

import br.com.casellisoftware.tocaform.services.exceptions.PhoneNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import static br.com.casellisoftware.tocaform.enums.messages.ExceptionDefaultMessages.*;
@ControllerAdvice
public class ResourceExceptionHandler {



    @ExceptionHandler(DiscipleNotFoundException.class)
    public ResponseEntity<StandardError> discipleNotFound(DiscipleNotFoundException dnfe, HttpServletRequest request){
        return ResponseEntity.ok().body(StandardError.builder()
                .timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime())
                .status(NOT_FOUND.value())
                .error(ENTITY_NOT_FOUND.getDescription())
                .message(dnfe.getMessage())
                .path(request.getServletPath())
                .build());
    }

    @ExceptionHandler(PhoneNotFoundException.class)
    public ResponseEntity<StandardError> phoneNotFound(PhoneNotFoundException pnfe, HttpServletRequest request){
        return ResponseEntity.ok().body(StandardError.builder()
                .timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime())
                .status(NOT_FOUND.value())
                .error(ENTITY_NOT_FOUND.getDescription())
                .message(pnfe.getMessage())
                .path(request.getServletPath())
                .build());
    }
}
