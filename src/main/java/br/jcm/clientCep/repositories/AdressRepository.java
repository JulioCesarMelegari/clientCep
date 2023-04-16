package br.jcm.clientCep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jcm.clientCep.entities.Adress;

public interface AdressRepository extends JpaRepository<Adress, String>{

}
