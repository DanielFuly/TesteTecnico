package br.com.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.entity.Aluno;
import br.com.desafio.repository.AlunoRepository;
import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunorepository;
	
	public Aluno buscarporid(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunorepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Aluno.class.getName()));		
	}
	
	public List<Aluno> listarAlunos(){
		return alunorepository.findAll();
	}

	public Aluno inserir(Aluno aluno) {
		return alunorepository.save(aluno);
	}
}
