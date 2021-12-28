package br.com.casellisoftware.tocaform.controllers.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = -2441092513644192857L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
