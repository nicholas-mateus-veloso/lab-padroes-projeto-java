package one.digitalinnovation.labpadroesprojetojava.repository;

import one.digitalinnovation.labpadroesprojetojava.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, String> {
}