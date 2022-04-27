package br.com.casellisoftware.tocaform.repositories;

import br.com.casellisoftware.tocaform.entities.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    @Query("SELECT obj from Visitor obj where obj.visitorState = false")
    List<Visitor> findAllByVisitorState();

    List<Visitor> findByNameContainingIgnoreCase(String name);
}
