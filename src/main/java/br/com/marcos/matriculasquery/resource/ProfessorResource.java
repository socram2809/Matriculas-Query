package br.com.marcos.matriculasquery.resource;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.matriculasquery.repository.ProfessorRepository;

/**
 * Controlador REST que mapeia a URI "/professor" para ser processada
 * @author Marcos Macedo
 *
 */
@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	
	/**
	 * Injeção de dependência para utilizar o repositório de Professor
	 */
	@Autowired
	private ProfessorRepository professorRepository;
	
	/**
	 * Processa requisições que utilizam o método DELETE do HTTP para remover um professor
	 * @param id
	 */
	@Transactional
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}
}
