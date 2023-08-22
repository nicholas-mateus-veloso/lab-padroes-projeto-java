package one.digitalinnovation.labpadroesprojetojava.service;

import one.digitalinnovation.labpadroesprojetojava.model.AddressEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    AddressEntity findByCep(@PathVariable("cep") String cep);
}