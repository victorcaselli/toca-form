package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.entities.Phone;
import br.com.casellisoftware.tocaform.repositories.PhoneRepository;
import br.com.casellisoftware.tocaform.services.exceptions.PhoneNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.com.casellisoftware.tocaform.enums.messages.ExceptionDefaultMessages.DISCIPLE_NOT_FOUND;

//TODO - Change all returns from Phone to PhoneDto
//TODO - Update method

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;


    @Transactional(readOnly = true)
    public List<Phone> findAll(){
        //TODO - Change to pageable
        return phoneRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Phone findById(Long id){
        return phoneRepository.findById(id)
                .orElseThrow(() -> new PhoneNotFoundException(DISCIPLE_NOT_FOUND.getDescription()));
    }

    @Transactional
    public Phone save(Phone phone){
        return phoneRepository.save(phone);
    }


    @Transactional
    public void deleteById(Long id){
        //TODO - Check for database exception
        phoneRepository.deleteById(id);
    }

}
