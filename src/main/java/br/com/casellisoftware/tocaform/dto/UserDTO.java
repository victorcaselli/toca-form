package br.com.casellisoftware.tocaform.dto;


import br.com.casellisoftware.tocaform.entities.User;
import br.com.casellisoftware.tocaform.util.ModelMapperUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -6171268145952677304L;

    @JsonIgnore
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Set<RoleDTO> roles = new HashSet<>();



    public static UserDTO toDto(User user){
        return ModelMapperUtil.map(user, UserDTO.class);
    }

    public User toEntity(){
        return ModelMapperUtil.map(this, User.class);
    }

}
