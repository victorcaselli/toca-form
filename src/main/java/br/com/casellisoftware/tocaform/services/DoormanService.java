package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.entities.Doorman;
import br.com.casellisoftware.tocaform.repositories.DoormanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class DoormanService {

    private final DoormanRepository doormanRepository;

    @Transactional
    public Doorman save(Doorman doorman){
        return doormanRepository.save(doorman);
    }

    @Transactional(readOnly = true)
    public Doorman findByTime(){
       return doormanRepository.findByEndDateAfter(LocalDateTime.now()).orElse(new Doorman());
    }

}
