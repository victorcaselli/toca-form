package br.com.casellisoftware.tocaform.repositories;

import br.com.casellisoftware.tocaform.entities.Disciple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscipleRepository extends JpaRepository<Disciple, Long> {

    List<Disciple> findByNameContainingIgnoreCase(
            @Param("name") String name
    );

}
