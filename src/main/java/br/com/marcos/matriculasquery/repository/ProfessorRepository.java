package br.com.marcos.matriculasquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcos.matriculasquery.dominio.Professor;

/**
 * Interface que estende JpaRepository, sendo possível utilizar as operações CRUD para Professor 
 * @author Marcos Macedo
 *
 */
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
