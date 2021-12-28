package br.com.casellisoftware.tocaform.entities;

import br.com.casellisoftware.tocaform.enums.ChristeningStatusType;
import br.com.casellisoftware.tocaform.enums.ChurchStatusType;
import br.com.casellisoftware.tocaform.enums.DecisionType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//TODO - COMMENTS ABOUT THIS CLASS
@SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_disciple")
public class Disciple implements Serializable {
    private static final long serialVersionUID = 2030386131859462656L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private String address;
    private String district;
    @ElementCollection
    private Set<Integer> decisionType = new HashSet<>();
    private Integer churchStatus;
    private Integer christeningStatus;
    @JsonManagedReference
    @OneToMany(mappedBy = "disciple", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();
    private String details;

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
