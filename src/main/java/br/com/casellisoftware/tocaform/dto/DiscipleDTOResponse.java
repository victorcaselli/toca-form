package br.com.casellisoftware.tocaform.dto;

import br.com.casellisoftware.tocaform.entities.Disciple;
import br.com.casellisoftware.tocaform.entities.Phone;
import br.com.casellisoftware.tocaform.enums.ChristeningStatusType;
import br.com.casellisoftware.tocaform.enums.ChurchStatusType;
import br.com.casellisoftware.tocaform.enums.DecisionType;
import br.com.casellisoftware.tocaform.util.ModelMapperUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiscipleDTOResponse implements Serializable {

    private static final long serialVersionUID = -1692469421567680385L;


    private Long id;
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String address;
    private String district;
    private Integer decisionType;
    private Integer churchStatus;
    private Integer christeningStatus;
    private List<Phone> phones = new ArrayList<>();
    private String details;


    public String getDecisionType() {
        return DecisionType.toEnum(decisionType).getDescription();
    }

    public String getChurchStatus() {
        return ChurchStatusType.toEnum(churchStatus).getDescription();
    }


    public String getChristeningStatus() {
        return ChristeningStatusType.toEnum(christeningStatus).getDescription();
    }


    public static DiscipleDTOResponse toDto(Disciple disciple){
        return ModelMapperUtil.map(disciple,DiscipleDTOResponse.class);
    }

    public Disciple toEntity(){
        return ModelMapperUtil.map(this, Disciple.class);
    }

}
