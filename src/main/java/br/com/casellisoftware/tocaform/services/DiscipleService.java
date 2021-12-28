package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.entities.Disciple;
import br.com.casellisoftware.tocaform.entities.Phone;
import br.com.casellisoftware.tocaform.repositories.DiscipleRepository;
import br.com.casellisoftware.tocaform.services.exceptions.DiscipleNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static br.com.casellisoftware.tocaform.enums.messages.ExceptionDefaultMessages.*;

import java.util.List;

//TODO - Change all returns from Disciple to DiscipleDto
//TODO - Update method

@Service
@RequiredArgsConstructor
public class DiscipleService {

    private final DiscipleRepository discipleRepository;


    @Transactional(readOnly = true)
    public List<Disciple> findAll(){
        //TODO - Change to pageable
        return discipleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Disciple findById(Long id){
        return discipleRepository.findById(id)
                .orElseThrow(() -> new DiscipleNotFoundException(DISCIPLE_NOT_FOUND.getDescription()));
    }

    @Transactional
    public Disciple save(Disciple disciple){
        return discipleRepository.save(disciple);
    }


    @Transactional
    public void deleteById(Long id){
        //TODO - Check for database exception
        discipleRepository.deleteById(id);
    }

}
