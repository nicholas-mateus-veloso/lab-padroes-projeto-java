package one.digitalinnovation.labpadroesprojetojava.controller;

import one.digitalinnovation.labpadroesprojetojava.model.ClientEntity;
import one.digitalinnovation.labpadroesprojetojava.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<ClientEntity>> buscarTodos() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientEntity> inserir(@RequestBody ClientEntity client) {
        clientService.save(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientEntity> atualizar(@PathVariable Long id, @RequestBody ClientEntity client) {
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
