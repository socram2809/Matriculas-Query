package br.com.marcos.matriculasquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.matriculasquery.dominio.Aluno;

/**
 * Interface que estende JpaRepository, sendo possível utilizar as operações CRUD para Aluno 
 * @author Marcos Macedo
 *
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
