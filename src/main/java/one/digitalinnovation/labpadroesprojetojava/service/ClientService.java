package one.digitalinnovation.labpadroesprojetojava.service;

import one.digitalinnovation.labpadroesprojetojava.model.ClientEntity;

public interface ClientService {
    Iterable<ClientEntity> findAll();

    ClientEntity findById(Long id);

    void save(ClientEntity client);

    void update(Long id, ClientEntity client);

    void delete(Long id);
}