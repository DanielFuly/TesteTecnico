package br.com.desafio.init;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.desafio.entity.Aluno;
import br.com.desafio.entity.Endereco;
import br.com.desafio.entity.Escola;
import br.com.desafio.entity.Turma;
import br.com.desafio.service.AlunoService;
import br.com.desafio.service.EnderecoService;
import br.com.desafio.service.EscolaService;
import br.com.desafio.service.TurmaService;


@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	
	@Autowired
	AlunoService alunoservice;
	
	@Autowired
	EnderecoService enderecoservice;
	
	@Autowired
	EscolaService escolaservice;
	
	@Autowired
	TurmaService turmaservice;
	
	
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 	
		
		//Insert dos dados de endereco
		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Rua São Jorge");
		endereco1.setComplemento("155");
		endereco1.setBairro("Flores");
		endereco1.setCidade("São Paulo");
		endereco1.setEstado("São Paulo");
		
		Endereco endereco2 = new Endereco();
		endereco2.setLogradouro("Rua Osvaldo da Cruz");
		endereco2.setComplemento("205");
		endereco2.setBairro("Maracanã");
		endereco2.setCidade("Rio de Janeiro");
		endereco2.setEstado("Rio de Janeiro");
		
		Endereco endereco3 = new Endereco();
		endereco3.setLogradouro("Rua 13 de Maio");
		endereco3.setComplemento("Casa 98");
		endereco3.setBairro("Engenho de dentro");
		endereco3.setCidade("Sobradinho");
		endereco3.setEstado("Brasilia");
		
		Endereco endereco4 = new Endereco();
		endereco4.setLogradouro("Rua Pôrto Alegre próximo ");
		endereco4.setComplemento("Predio 101");
		endereco4.setBairro("Sagrada Família");
		endereco4.setCidade("Agua Boa");
		endereco4.setEstado("Minas Gerais");
		
		enderecoservice.inserir(endereco1);
		enderecoservice.inserir(endereco2);
		enderecoservice.inserir(endereco3);
		enderecoservice.inserir(endereco4);
		
		//Insert dos dados de escola
		
		Escola escola1 = new Escola();
		escola1.setNome("Escola Municipal Professor Jose de Sá");
		escola1.setEndereco(endereco1);
				
		Escola escola2 = new Escola();
		escola2.setNome("Colégio Estadual Luis Eduardo Magalhães");
		escola2.setEndereco(endereco2);
				
		Escola escola3 = new Escola();
		escola3.setNome("Escola Estadual Regis Bitencourt");
		escola3.setEndereco(endereco3);
				
		Escola escola4 = new Escola();
		escola4.setNome("Colégio Santa Luzia");
		escola4.setEndereco(endereco4);
				
		escolaservice.inserir(escola1);
		escolaservice.inserir(escola2);
		escolaservice.inserir(escola3);
		escolaservice.inserir(escola4);	
		
		//Insert dos dados de turma
		Turma turma1 = new Turma();
		turma1.setNome("Matematica");
		turma1.setCapacidade(10);
		turma1.setEscola(escola2);
		
		Turma turma2 = new Turma();
		turma2.setNome("Portugues");
		turma2.setCapacidade(15);
		turma2.setEscola(escola1);
		
		Turma turma3 = new Turma();
		turma3.setNome("Geografia");
		turma3.setCapacidade(20);
		turma3.setEscola(escola3);
		
		Turma turma4 = new Turma();
		turma4.setNome("Historia");
		turma4.setCapacidade(25);
		turma4.setEscola(escola4);

		
		turmaservice.inserir(turma1);
		turmaservice.inserir(turma2);
		turmaservice.inserir(turma3);
		turmaservice.inserir(turma4);
	
	
		//Insert dos dados de aluno	
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Daniel");
		LocalDate data1 = LocalDate.parse("16/07/1997", formato); 
		aluno1.setDataDeNascimento(formato.format(data1));
		aluno1.setTurma(turma1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("João");
		LocalDate data2 = LocalDate.parse("07/04/1999", formato); 
		aluno2.setDataDeNascimento(formato.format(data2));
		aluno2.setTurma(turma2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Maria");
		LocalDate data3 = LocalDate.parse("16/07/1997", formato); 
		aluno3.setDataDeNascimento(formato.format(data3));
		aluno3.setTurma(turma4);
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Guilherme");
		LocalDate data4 = LocalDate.parse("16/07/1997", formato); 
		aluno4.setDataDeNascimento(formato.format(data4));
		aluno4.setTurma(turma3);
	
		
		
		alunoservice.inserir(aluno1);
		alunoservice.inserir(aluno2);
		alunoservice.inserir(aluno3);
		alunoservice.inserir(aluno4);
		
		
		
	}
	
}
