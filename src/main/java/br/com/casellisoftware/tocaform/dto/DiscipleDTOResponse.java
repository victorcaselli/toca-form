package br.com.casellisoftware.tocaform.dto;

import br.com.casellisoftware.tocaform.entities.Disciple;
import br.com.casellisoftware.tocaform.enums.ChristeningStatusType;
import br.com.casellisoftware.tocaform.enums.ChurchStatusType;
import br.com.casellisoftware.tocaform.enums.DecisionType;
import br.com.casellisoftware.tocaform.util.ModelMapperUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiscipleDTOResponse implements Serializable {

    private static final long serialVersionUID = -1692469421567680385L;


    private Long id;
    private String name;
    private String birthDate;
    private String address;
    private String district;
    private Integer decisionType;
    private Integer churchStatus;
    private Integer christeningStatus;
    private String details;
    private VisitorDTO visitor;
    private UserDTO createdBy;
    private String phone;


    public String getDecisionType() {
        try{
            return DecisionType.toEnum(decisionType).getDescription();
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    public String getChurchStatus() {
        try{
            return ChurchStatusType.toEnum(churchStatus).getDescription();
        }catch (IllegalArgumentException e){
            return null;
        }
    }


    public String getChristeningStatus() {
        try{
            return ChristeningStatusType.toEnum(christeningStatus).getDescription();
        }catch (IllegalArgumentException e){
            return null;
        }
    }


    public static DiscipleDTOResponse toDto(Disciple disciple){
        return ModelMapperUtil.map(disciple,DiscipleDTOResponse.class);
    }

    public Disciple toEntity(){
        return ModelMapperUtil.map(this, Disciple.class);
    }

}
