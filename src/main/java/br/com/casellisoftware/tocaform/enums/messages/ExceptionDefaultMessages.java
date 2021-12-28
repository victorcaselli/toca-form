package br.com.casellisoftware.tocaform.enums.messages;

import br.com.casellisoftware.tocaform.enums.GlobalEnumeration;
import br.com.casellisoftware.tocaform.util.EnumerationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionDefaultMessages implements GlobalEnumeration {

    DISCIPLE_NOT_FOUND(0, "Disciple object sought cannot be found."),
    PHONE_NOT_FOUND(1, "Phone object sought cannot be found."),
    ENTITY_NOT_FOUND(2, "Entity not found");

    private Integer code;
    private String description;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public Object getEnum(Integer code) {
        return code;
    }

    @Override
    public Object[] allValues() {
        return new Object[0];
    }

    public static ExceptionDefaultMessages toEnum(Integer code){
        return (ExceptionDefaultMessages) EnumerationUtil.toEnum(code, ExceptionDefaultMessages.values());
    }
}
