package one.digitalinnovation.labpadroesprojetojava.service.impl;

import one.digitalinnovation.labpadroesprojetojava.model.AddressEntity;
import one.digitalinnovation.labpadroesprojetojava.model.ClientEntity;
import one.digitalinnovation.labpadroesprojetojava.repository.AddressRepository;
import one.digitalinnovation.labpadroesprojetojava.repository.ClientRepository;
import one.digitalinnovation.labpadroesprojetojava.service.ClientService;
import one.digitalinnovation.labpadroesprojetojava.service.ViaCepService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final ViaCepService viaCepService;

    public ClientServiceImpl(
            ClientRepository clientRepository,
            AddressRepository addressRepository,
            ViaCepService viaCepService
    ) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Iterable<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity findById(Long id) {
        final Optional<ClientEntity> client = getClientEntityById(id);

        return client.orElse(null);
    }

    @Override
    public void save(ClientEntity client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, ClientEntity client) {
        final Optional<ClientEntity> clientById = getClientEntityById(id);

        if (clientById.isPresent()) {
            saveClientWithCep(client);
        }
    }

    private Optional<ClientEntity> getClientEntityById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        final Optional<ClientEntity> client = getClientEntityById(id);
        if (client.isPresent()) {
            clientRepository.deleteById(id);
        }
    }

    private void saveClientWithCep(ClientEntity client) {
        String cep = client.getAddress().getCep();
        AddressEntity address = addressRepository.findById(cep).orElseGet(() -> {
            AddressEntity newAddress = viaCepService.findByCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);

        clientRepository.save(client);
    }
}