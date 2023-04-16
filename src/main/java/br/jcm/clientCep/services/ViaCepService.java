package br.jcm.clientCep.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.jcm.clientCep.entities.Adress;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
	
	@GetMapping("/{cep}/json/")
	Adress consultCep(@PathVariable("cep") String cep);

}
