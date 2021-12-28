package br.com.casellisoftware.tocaform.enums.messages;

import br.com.casellisoftware.tocaform.enums.GlobalEnumeration;
import br.com.casellisoftware.tocaform.util.EnumerationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionDefaultMessages implements GlobalEnumeration {

    DISCIPLE_NOT_FOUND(0, "Disciple not found");

    private Integer code;
    private String description;

    @Override
    public Integer getCode() {
        return code;
    }

    public static ExceptionDefaultMessages toEnum(Integer code){
        return (ExceptionDefaultMessages) EnumerationUtil.toEnum(code, ExceptionDefaultMessages.values());
    }
}
