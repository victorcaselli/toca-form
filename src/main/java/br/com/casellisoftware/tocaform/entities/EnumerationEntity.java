package br.com.casellisoftware.tocaform.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnumerationEntity implements Serializable {
    private static final long serialVersionUID = 6524841165810275535L;

    private Integer code;
    private String description;
    private Object enumeration;
}
