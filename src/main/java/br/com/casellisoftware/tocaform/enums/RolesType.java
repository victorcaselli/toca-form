package br.com.casellisoftware.tocaform.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RolesType {

    ADMIN(0, "ADMIN"),
    DISCIPLE_RECORDER(1, "DISCIPLE_RECORDER"),
    DISCIPLE_FINDER(2, "DISCIPLE_FINDER"),
    PASTOR(3, "PASTOR");

    private final Integer code;
    private final String description;


    public static RolesType toEnum(Integer code){
        if(code == null)
            return null;

        for(RolesType rt : RolesType.values()){
            if(rt.getCode().equals(code))
                return rt;
        }

        throw new IllegalArgumentException("Invalid code, code: "+code);
    }
}
