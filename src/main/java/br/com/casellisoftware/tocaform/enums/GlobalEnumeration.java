package br.com.casellisoftware.tocaform.enums;

public interface GlobalEnumeration {

    Integer getCode();

    String getDescription();

    Object getEnum(Integer code);

    Object[] allValues();
}
