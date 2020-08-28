package br.com.marcos.matriculasquery.resource;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.matriculasquery.repository.TurmaRepository;

/**
 * Controlador REST que mapeia a URI "/turma" para ser processada
 * @author Marcos Macedo
 *
 */
@RestController
@RequestMapping("/turma")
public class TurmaResource {

	/**
	 * Injeção de dependência para utilizar o repositório de Turma
	 */
	@Autowired
	private TurmaRepository turmaRepository;
	
	/**
	 * Processa requisições que utilizam o método DELETE do HTTP para remover uma turma
	 * @param id
	 */
	@Transactional
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerTurma(@PathVariable Long id) {
		turmaRepository.deleteById(id);
	}
}
