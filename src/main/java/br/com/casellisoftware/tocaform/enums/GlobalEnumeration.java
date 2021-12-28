package br.com.casellisoftware.tocaform.enums;

//TODO - Remove allValues in the future if it is never used again

public interface GlobalEnumeration {

    Integer getCode();

    String getDescription();

    Object getEnum(Integer code);

    Object[] allValues();
}
