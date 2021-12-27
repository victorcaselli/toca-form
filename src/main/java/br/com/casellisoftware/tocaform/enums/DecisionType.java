package br.com.casellisoftware.tocaform.enums;

import br.com.casellisoftware.tocaform.util.EnumerationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DecisionType implements GlobalEnumeration {

    ACCEPT_JESUS(0, "Aceitar a Jesus como seu Salvador"),
    RECONCILIATION(1, "Reconciliar-se com Cristo e a Igreja"),
    BAPTIZED(2, "Ser batizado em águas");

    private Integer code;
    private String description;

    @Override
    public Integer getCode() {
        return code;
    }

    public static DecisionType toEnum(Integer code){
        return (DecisionType) EnumerationUtil.toEnum(code, DecisionType.values());
    }
}
