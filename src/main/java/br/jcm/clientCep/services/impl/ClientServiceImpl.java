package br.jcm.clientCep.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jcm.clientCep.entities.Adress;
import br.jcm.clientCep.entities.Client;
import br.jcm.clientCep.repositories.AdressRepository;
import br.jcm.clientCep.repositories.ClientRepository;
import br.jcm.clientCep.services.ClientService;
import br.jcm.clientCep.services.ViaCepService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AdressRepository adressRepository;
	@Autowired
	private ViaCepService viaserCepService;
	

	@Override
	public Iterable<Client> ListAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client getById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}

	@Override
	public void insert(Client client) {
		saveClientCep(client);
	}
	
	@Override
	public void update(Long id, Client client) {
		Optional<Client> clientDb = clientRepository.findById(id);
		if(clientDb.isPresent()) {
			saveClientCep(client);
		}
	}

	private void saveClientCep(Client client) {
		String cep = client.getAdress().getCep();
		Adress adress = adressRepository.findById(cep).orElseGet(() ->{
			Adress newAdress = viaserCepService.consultCep(cep);
			adressRepository.save(newAdress);
			return newAdress;
		});
		client.setAdress(adress);
		clientRepository.save(client);
	}

	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);	
	}
}
