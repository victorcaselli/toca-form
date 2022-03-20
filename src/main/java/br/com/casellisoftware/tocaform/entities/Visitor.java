package br.com.casellisoftware.tocaform.entities;

import br.com.casellisoftware.tocaform.enums.VisitorType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_visitor")
public class Visitor implements Serializable {
    private static final long serialVersionUID = -6017966800630916002L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private Boolean firstTime;
    private Integer visitorType;
    private String phone;

    public Integer getVisitorType(){
        return VisitorType.toEnum(visitorType).getCode();
    }

    public void setVisitorType(Integer code){
        this.visitorType = VisitorType.toEnum(code).getCode();
    }

}