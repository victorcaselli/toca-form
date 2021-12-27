package br.com.casellisoftware.tocaform.entities;

import br.com.casellisoftware.tocaform.enums.PhoneType;
import br.com.casellisoftware.tocaform.enums.WhatsappStatusType;
import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Phone implements Serializable {

    private static final long serialVersionUID = -3345854559417725575L;
    private Long id;
    private Integer ddd;
    private Long number;
    private Integer phoneType;
    private Integer whatsapp;
    private Disciple disciple;

    public Integer getPhoneType() {
        return PhoneType.toEnum(phoneType).getCode();
    }

    public void setPhoneType(Integer phoneType) {
        this.phoneType = PhoneType.toEnum(phoneType).getCode();
    }

    public Integer getWhatsapp() {
        return WhatsappStatusType.toEnum(whatsapp).getCode();
    }

    public void setWhatsapp(Integer whatsapp) {
        this.whatsapp = WhatsappStatusType.toEnum(whatsapp).getCode();
    }
}
