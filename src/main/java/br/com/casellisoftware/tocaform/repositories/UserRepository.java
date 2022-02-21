package br.com.casellisoftware.tocaform.repositories;

import br.com.casellisoftware.tocaform.entities.Disciple;
import br.com.casellisoftware.tocaform.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByUsername(String username);
}
