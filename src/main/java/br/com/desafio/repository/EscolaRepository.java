package br.com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.entity.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer> {

}
