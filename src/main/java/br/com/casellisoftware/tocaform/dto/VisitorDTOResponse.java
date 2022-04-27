package br.com.casellisoftware.tocaform.dto;

import br.com.casellisoftware.tocaform.entities.Visitor;
import br.com.casellisoftware.tocaform.enums.VisitorType;
import br.com.casellisoftware.tocaform.util.ModelMapperUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VisitorDTOResponse implements Serializable {
    private static final long serialVersionUID = -5837469587224837528L;

    private Long id;
    private String name;
    private String birthDate;
    private Boolean firstTime;
    private Integer visitorType;
    private String phone;
    @JsonIgnore
    private DiscipleDTOResponse disciple;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime createdAt;


    public static VisitorDTOResponse toDto(Visitor visitor){
        return ModelMapperUtil.map(visitor, VisitorDTOResponse.class);
    }

    public Visitor toEntity(){
        return ModelMapperUtil.map(this, Visitor.class);
    }


    public String getVisitorType(){
        return VisitorType.toEnum(visitorType).getDescription();
    }

    public void setVisitorType(Integer code){
        this.visitorType = VisitorType.toEnum(code).getCode();
    }
}
