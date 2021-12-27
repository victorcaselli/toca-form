package br.com.casellisoftware.tocaform.entities;

import br.com.casellisoftware.tocaform.enums.ChristeningStatusType;
import br.com.casellisoftware.tocaform.enums.ChurchStatusType;
import br.com.casellisoftware.tocaform.enums.DecisionType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Disciple implements Serializable {
    private static final long serialVersionUID = 2030386131859462656L;

    private Long id;
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String address;
    private String additionalDetails;
    private String district;
    private Set<Integer> decisionType = new HashSet<>();
    private Integer churchStatus;
    private Integer christeningStatus;
    private List<Phone> phones = new ArrayList<>();

    public List<Integer> getDecisionType(){
        return decisionType.stream()
                .map(decisionType -> DecisionType.toEnum(decisionType).getCode())
                .collect(Collectors.toList());
    }

    public void setDecisionType(Integer decisionType){
        this.decisionType.add(DecisionType.toEnum(decisionType).getCode());
    }

    public Integer getChurchStatus() {
        return ChurchStatusType.toEnum(churchStatus).getCode();
    }

    public void setChurchStatus(Integer churchStatus){
        this.churchStatus = ChurchStatusType.toEnum(churchStatus).getCode();
    }

    public Integer getChristeningStatus(){
        return ChristeningStatusType.toEnum(christeningStatus).getCode();
    }

    public void setChristeningStatus(Integer christeningStatus){
        this.christeningStatus = ChristeningStatusType.toEnum(christeningStatus).getCode();
    }


}
