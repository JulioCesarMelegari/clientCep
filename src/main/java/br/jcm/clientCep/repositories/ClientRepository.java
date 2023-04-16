package br.jcm.clientCep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jcm.clientCep.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
