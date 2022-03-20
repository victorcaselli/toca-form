package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.dto.VisitorDTO;
import br.com.casellisoftware.tocaform.repositories.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.casellisoftware.tocaform.dto.VisitorDTO.toDto;

@RequiredArgsConstructor
@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    @Transactional
    public VisitorDTO save(VisitorDTO visitorDTO){
        return toDto(
                visitorRepository.save(visitorDTO.toEntity())
                );
    }
    @Transactional(readOnly = true)
    public List<VisitorDTO> findAll(){
        return visitorRepository.findAll()
                .stream()
                .map(VisitorDTO::toDto)
                .collect(Collectors.toList());
    }
}
