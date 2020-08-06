package br.com.desafio.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.desafio.entity.Aluno;
import br.com.desafio.service.AlunoService;
import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoservice;
		
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listarAlunos() {
		List<Aluno> listaAlunos = alunoservice.listarAlunos();
		return ResponseEntity.ok().body(listaAlunos);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Aluno objAluno = alunoservice.buscarporid(id);
		return ResponseEntity.ok().body(objAluno);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Aluno objAluno) {
		objAluno = alunoservice.inserir(objAluno);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objAluno.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
