package br.com.casellisoftware.tocaform.enums;

import br.com.casellisoftware.tocaform.util.EnumerationUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WhatsappStatusType implements GlobalEnumeration {

    ONLY(0, "Somente Whatsapp"),
    WHATSAPP(1, "Também pode ser usado no whatsapp");

    private Integer code;
    private String description;

    @Override
    public Integer getCode() {
        return code;
    }

    public static WhatsappStatusType toEnum(Integer code){
        return (WhatsappStatusType) EnumerationUtil.toEnum(code, WhatsappStatusType.values());
    }
}
