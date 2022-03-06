package br.com.casellisoftware.tocaform.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = -68944789169734728L;

    private Long id;
    private String authority;
}
