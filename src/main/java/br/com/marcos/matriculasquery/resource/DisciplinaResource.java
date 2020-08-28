package br.com.marcos.matriculasquery.resource;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.matriculasquery.repository.DisciplinaRepository;

/**
 * Controlador REST que mapeia a URI "/disciplina" para ser processada
 * @author Marcos Macedo
 *
 */
@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	/**
	 * Injeção de dependência para utilizar o repositório de Disciplina
	 */
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	/**
	 * Processa requisições que utilizam o método DELETE do HTTP para remover uma disciplina
	 * @param id
	 */
	@Transactional
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removerDisciplina(@PathVariable Long id) {
		disciplinaRepository.deleteById(id);
	}
}
