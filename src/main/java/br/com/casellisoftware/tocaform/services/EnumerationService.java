package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.entities.EnumerationEntity;
import br.com.casellisoftware.tocaform.enums.GlobalEnumeration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnumerationService {


    public List<EnumerationEntity> getAll(GlobalEnumeration[] globalEnumeration){
        List<EnumerationEntity> enumEntities = new ArrayList<>();
        for(GlobalEnumeration obj : globalEnumeration){
            enumEntities.add(new EnumerationEntity(obj.getCode(), obj.getDescription(), obj.getEnum(obj.getCode())));
        }

        return enumEntities;
    }

}
