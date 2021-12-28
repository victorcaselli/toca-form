package br.com.casellisoftware.tocaform.services.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DiscipleNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 8273558759287352003L;

    public DiscipleNotFoundException(String message){
        super(message);
    }


}
