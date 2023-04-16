package br.jcm.clientCep.services;

import br.jcm.clientCep.entities.Client;

public interface ClientService {
	
	Iterable<Client> ListAll();
	
	Client getById(Long id);
	
	public void insert(Client client);
	
	public void update(Long id, Client client);
	
	public void delete(Long id);

}
