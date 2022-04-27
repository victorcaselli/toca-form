package br.com.casellisoftware.tocaform.services;

import br.com.casellisoftware.tocaform.dto.VisitorDTORequest;
import br.com.casellisoftware.tocaform.dto.VisitorDTOResponse;
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

@RequiredArgsConstructor
@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;
    private final DiscipleService discipleService;
    private final UserRepository userRepository;

    @Transactional
    public VisitorDTORequest save(VisitorDTORequest visitorDTORequest){
        Visitor visitor = visitorRepository.save(visitorDTORequest.toEntity());
        visitor.setCreatedAt(LocalDateTime.now());
        return VisitorDTORequest.toDto(visitor);

    }
    @Transactional(readOnly = true)
    public List<VisitorDTOResponse> findAll(){
        return visitorRepository.findAllByVisitorState()
                .stream()
                .map(VisitorDTOResponse::toDto)
                .collect(Collectors.toList());
    }


    public void createDiscipleFromVisitor(Long visitorsId){

        Visitor visitor = visitorRepository.findById(visitorsId)
                .orElseThrow(() -> new IllegalArgumentException("Visitors not found"));

        visitor.setVisitorState(true);

        visitor = visitorRepository.save(visitor);

        discipleService.save(Disciple.builder()
                .birthDate(visitor.getBirthDate())
                .createAt(LocalDateTime.now())
                .name(visitor.getName())
                .phone(visitor.getPhone())

//                        .createdBy(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString())
//                                .orElseThrow(() -> new IllegalArgumentException("User not found")))

                .build());

    }


    @Transactional
    public void deleteById(Long visitorId){
        visitorRepository.deleteById(visitorId);
    }



    @Transactional(readOnly = true)
    public List<VisitorDTOResponse> findAllByParams(String name){
        if(name == null || name.isEmpty() || name.isBlank()) {
            return findAll();
        }

        return visitorRepository.findByNameContainingIgnoreCase(name).stream()
                .map(VisitorDTOResponse::toDto)
                .collect(Collectors.toList());

    }
}
