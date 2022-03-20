package br.com.casellisoftware.tocaform.enums;

import br.com.casellisoftware.tocaform.util.EnumerationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VisitorType implements GlobalEnumeration {

    YOURSELF(0, "Por interesse próprio"),
    FRIENDS(1, "Através de amigos"),
    SOCIAL_MEDIA(2, "Redes sociais"),
    FAMILY(3, "Através da família");

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
        return VisitorType.values();
    }

    public static VisitorType toEnum(Integer code){
        return (VisitorType) EnumerationUtil.toEnum(code, VisitorType.values());
    }
}
