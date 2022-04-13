package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.dto.DiscipleDTOResponse;
import br.com.casellisoftware.tocaform.entities.Disciple;
import br.com.casellisoftware.tocaform.repositories.DiscipleRepository;
import br.com.casellisoftware.tocaform.services.exceptions.DiscipleNotFoundException;
import br.com.casellisoftware.tocaform.util.EnvironmentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.casellisoftware.tocaform.dto.DiscipleDTOResponse.toDto;
import static br.com.casellisoftware.tocaform.enums.messages.ExceptionDefaultMessages.DISCIPLE_NOT_FOUND;

//TODO - Change all returns from Disciple to DiscipleDto
//TODO - Update method

@Service
@RequiredArgsConstructor
public class DiscipleService {

    private final DiscipleRepository discipleRepository;
    private final EnvironmentUtil environmentUtil;


    @Transactional(readOnly = true)
    public List<DiscipleDTOResponse> findAll(){
        //TODO - Change to pageable
        return discipleRepository.findAll()
                .stream().map(DiscipleDTOResponse::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DiscipleDTOResponse findById(Long id){
        return toDto(
                discipleRepository.findById(id)
                .orElseThrow(() -> new DiscipleNotFoundException(DISCIPLE_NOT_FOUND.getDescription()))
        );
    }

    @Transactional
    public Disciple save(Disciple disciple){

        disciple.setCreateAt(LocalDateTime.now());

        return discipleRepository.save(disciple);
    }


    @Transactional
    public void deleteById(Long id){
        //TODO - Check for database exception
        discipleRepository.deleteById(id);
    }

    @Transactional
    public List<DiscipleDTOResponse> findAllByParams(String name){
        if(name == null || name.isEmpty() || name.isBlank()) {
            return findAll();
        }

        return discipleRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(DiscipleDTOResponse::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteAll(){
        if(environmentUtil.getProfileByName("hom")){
            this.discipleRepository.deleteAll();
        }
    }
}
