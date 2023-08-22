package one.digitalinnovation.labpadroesprojetojava.repository;

import one.digitalinnovation.labpadroesprojetojava.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}