package br.jcm.clientCep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.jcm.clientCep.entities.Client;
import br.jcm.clientCep.services.ClientService;

@RestController("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public ResponseEntity<Iterable<Client>> listAll(){
		return ResponseEntity.ok(clientService.ListAll());
	}
	
	public ResponseEntity<Client> getById(@PathVariable Long id){
		return ResponseEntity.ok(clientService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody Client client){
		clientService.insert(client);
		return ResponseEntity.ok(client);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> Update(@PathVariable  Long id, @RequestBody Client client){
		clientService.update(id, client);
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		clientService.delete(id);
		return ResponseEntity.ok().build();
	}
}
