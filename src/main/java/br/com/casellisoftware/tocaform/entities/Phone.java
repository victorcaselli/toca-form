package br.com.casellisoftware.tocaform.entities;

import br.com.casellisoftware.tocaform.enums.PhoneType;
import br.com.casellisoftware.tocaform.enums.WhatsappStatusType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//TODO - COMMENTS ABOUT THIS CLASS
@SuppressWarnings({"unused", "JpaDataSourceORMInspection"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_phone", schema = "tocaform")
public class Phone implements Serializable {
    private static final long serialVersionUID = -3345854559417725575L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ddd;
    private Long number;
    private Integer phoneType;
    private Integer whatsapp;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_disciple",nullable = false)
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
