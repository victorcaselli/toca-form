package br.com.casellisoftware.tocaform.util;

import br.com.casellisoftware.tocaform.enums.GlobalEnumeration;

/**
 * Basic method to convert an integer to enum type. This method should be implemented in our custom enum types
 *
 * @author V. D. Caselli
 * @since 1.0
 */
public class EnumerationUtil {

    public static GlobalEnumeration toEnum(Integer code, Object[] values){

        for (Object global : values){
            if(global instanceof GlobalEnumeration){
                if(((GlobalEnumeration) global).getCode().equals(code)){
                    return (GlobalEnumeration) global;
                }
            }
        }

        //TODO - Change default java exception to custom exception
        throw new IllegalArgumentException("Invalid code. Code: "+code);
    }
}
