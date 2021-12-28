package br.com.casellisoftware.tocaform.util;


import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UriUtil {

    /**
     * Easy way to generate uri for the Http created method
     *
     * @param id id of the persisted object
     * @return URI
     */

    public static URI getUri(Long id){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
