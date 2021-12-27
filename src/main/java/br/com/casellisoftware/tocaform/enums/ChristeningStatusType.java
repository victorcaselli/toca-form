package br.com.casellisoftware.tocaform.enums;

import br.com.casellisoftware.tocaform.util.EnumerationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ChristeningStatusType implements GlobalEnumeration {

    CHRISTENING(0, "Batizado"),
    NON_CHRISTENING(1, "Não batizado");

    private Integer code;
    private String description;

    @Override
    public Integer getCode() {
        return code;
    }

    public static ChristeningStatusType toEnum(Integer code){
        return (ChristeningStatusType) EnumerationUtil.toEnum(code, ChristeningStatusType.values());
    }
}
