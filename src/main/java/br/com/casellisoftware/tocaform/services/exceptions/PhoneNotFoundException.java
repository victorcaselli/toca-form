package br.com.casellisoftware.tocaform.services.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PhoneNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 8273558759287352003L;

    public PhoneNotFoundException(String message){
        super(message);
    }


}
