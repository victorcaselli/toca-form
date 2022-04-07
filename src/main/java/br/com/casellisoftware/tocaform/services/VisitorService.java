package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.dto.VisitorDTO;
import br.com.casellisoftware.tocaform.entities.Disciple;
import br.com.casellisoftware.tocaform.entities.Visitor;
import br.com.casellisoftware.tocaform.repositories.UserRepository;
import br.com.casellisoftware.tocaform.repositories.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.casellisoftware.tocaform.dto.VisitorDTO.toDto;

@RequiredArgsConstructor
@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;
    private final DiscipleService discipleService;
    private final UserRepository userRepository;

    @Transactional
    public VisitorDTO save(VisitorDTO visitorDTO){
        Visitor visitor = visitorRepository.save(visitorDTO.toEntity());
        visitor.setCreatedAt(LocalDateTime.now());
        createDiscipleFromVisitor(visitor);

        return toDto(visitor);

    }
    @Transactional(readOnly = true)
    public List<VisitorDTO> findAll(){
        return visitorRepository.findAll()
                .stream()
                .map(VisitorDTO::toDto)
                .collect(Collectors.toList());
    }


    public void createDiscipleFromVisitor(Visitor visitor){

        discipleService.save(Disciple.builder()
                .birthDate(visitor.getBirthDate())
                .createAt(LocalDateTime.now())
                .name(visitor.getName())
                .visitor(visitor)
//                        .createdBy(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
//                                .orElseThrow(() -> new IllegalArgumentException("User not found")))

                .build());

    }
}
