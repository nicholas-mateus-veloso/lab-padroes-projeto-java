package one.digitalinnovation.labpadroesprojetojava.service.impl;

import one.digitalinnovation.labpadroesprojetojava.model.AddressEntity;
import one.digitalinnovation.labpadroesprojetojava.service.ViaCepService;
import org.springframework.stereotype.Service;


@Service
public class ViaServiceImpl implements ViaCepService {
    @Override
    public AddressEntity findByCep(String cep) {
        return null;
    }
}
