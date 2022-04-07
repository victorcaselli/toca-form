package br.com.casellisoftware.tocaform.repositories;

import br.com.casellisoftware.tocaform.entities.AppConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigurationRepository extends JpaRepository<AppConfiguration, Long> {


    Optional<AppConfiguration> findByState(boolean state);
}
