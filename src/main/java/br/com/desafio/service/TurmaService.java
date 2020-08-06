package br.com.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.entity.Turma;
import br.com.desafio.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository turmarepository;
	
	public Turma inserir(Turma turma) {
		return turmarepository.save(turma);
	}

}
