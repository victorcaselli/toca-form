package br.com.casellisoftware.tocaform.entities;

import br.com.casellisoftware.tocaform.enums.ChristeningStatusType;
import br.com.casellisoftware.tocaform.enums.ChurchStatusType;
import br.com.casellisoftware.tocaform.enums.DecisionType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TODO - COMMENTS ABOUT THIS CLASS
@SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_disciple", schema = "tocaform")
public class Disciple implements Serializable {
    private static final long serialVersionUID = 2030386131859462656L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String birthDate;
    private String address;
    private String district;
    private Integer  decisionType;
    private Integer churchStatus;
    private Integer christeningStatus;
    @ElementCollection
    private List<String> phones = new ArrayList<>();
    private String details;
    private LocalDateTime createAt;
    @OneToOne
    @JoinColumn(name = "visitor_id")
    private Visitor visitor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User createdBy;

    public Integer getDecisionType(){
        try{
            return DecisionType.toEnum(decisionType).getCode();
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    public void setDecisionType(Integer decisionType){
        this.decisionType = DecisionType.toEnum(decisionType).getCode();
    }

    public Integer getChurchStatus() {
        try{
            return ChurchStatusType.toEnum(churchStatus).getCode();
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    public void setChurchStatus(Integer churchStatus){
        this.churchStatus = ChurchStatusType.toEnum(churchStatus).getCode();
    }

    public Integer getChristeningStatus(){
        try{
            return ChristeningStatusType.toEnum(christeningStatus).getCode();
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    public void setChristeningStatus(Integer christeningStatus){
        this.christeningStatus = ChristeningStatusType.toEnum(christeningStatus).getCode();
    }


}
