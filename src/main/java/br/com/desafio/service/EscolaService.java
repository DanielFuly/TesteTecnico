package br.com.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.entity.Escola;
import br.com.desafio.repository.EscolaRepository;

@Service
public class EscolaService {

	@Autowired
	EscolaRepository escolarepository;
	
	public Escola inserir(Escola escola) {
		return escolarepository.save(escola);
	}
	
}
