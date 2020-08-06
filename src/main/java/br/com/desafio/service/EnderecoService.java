package br.com.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.entity.Endereco;
import br.com.desafio.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecorepository;
	
	public Endereco inserir(Endereco endereco) {
		return enderecorepository.save(endereco);
	}

}
