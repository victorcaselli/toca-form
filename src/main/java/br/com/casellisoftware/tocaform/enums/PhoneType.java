package br.com.casellisoftware.tocaform.enums;

import br.com.casellisoftware.tocaform.util.EnumerationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@AllArgsConstructor
@Getter
public enum PhoneType implements GlobalEnumeration {

    CELLPHONE(0, "Celular"),
    PARENT_CELLPHONE(1, "Telefone do responsável"),
    RESIDENTIAL(2, "Telefone fixo / Residencial");

    private Integer code;
    private String description;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public Object getEnum(Integer code) {
        return toEnum(code);
    }

    @Override
    public Object[] allValues() {
        return PhoneType.values();
    }

    public static PhoneType toEnum(Integer code){
        return (PhoneType) EnumerationUtil.toEnum(code, PhoneType.values());
    }
}
