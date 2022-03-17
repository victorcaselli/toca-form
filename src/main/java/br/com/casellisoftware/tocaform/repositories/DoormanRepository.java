package br.com.casellisoftware.tocaform.repositories;


import br.com.casellisoftware.tocaform.entities.Doorman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface DoormanRepository extends JpaRepository<Doorman, Long> {

    Optional<Doorman> findByEndDateAfter(LocalDateTime now);
}
