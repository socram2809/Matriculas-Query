package br.com.marcos.matriculasquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.matriculasquery.dominio.Turma;

/**
 * Interface que estende JpaRepository, sendo possível utilizar as operações CRUD para Turma 
 * @author Marcos Macedo
 *
 */
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
