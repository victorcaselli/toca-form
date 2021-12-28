package br.com.casellisoftware.tocaform.enums;

import br.com.casellisoftware.tocaform.util.EnumerationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ChurchStatusType implements GlobalEnumeration {

    DISCIPLE(0, "Membro de Betânia"),
    OUT_OF_HOUSE(1, "De outra igreja"),
    OUT_OF_CHURCH(2, "De nenhuma igreja");

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
        return ChurchStatusType.values();
    }

    public static ChurchStatusType toEnum(Integer code){
        return (ChurchStatusType) EnumerationUtil.toEnum(code, ChurchStatusType.values());
    }
}
