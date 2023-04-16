package br.jcm.clientCep.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Adress {
	
	@Id
	public String cep;
	public String logradouro;
	public String complemento;
	public String bairro;
	public String localidade;
	public String uf;

}
