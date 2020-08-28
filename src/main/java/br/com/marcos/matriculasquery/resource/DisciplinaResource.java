package br.com.marcos.matriculasquery.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.matriculascore.dto.AtualizarDisciplinaDTO;
import br.com.marcos.matriculasquery.dto.DisciplinaDTO;
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
	 * Processa requisições que utilizam o método GET do HTTP para retornar todas as disciplinas
	 * @return
	 */
	@GetMapping
	public List<DisciplinaDTO> recuperarDisciplinas(){
		return DisciplinaDTO.transformaEmDTO(disciplinaRepository.findAll());
	}
	
	/**
	 * Escuta eventos de criação/alteração de disciplina advindos do serviço core
	 * @param disciplina
	 */
	@JmsListener(destination = "disciplina.update", containerFactory = "jmsFactoryTopic")
	public void onDisciplinaUpdate(AtualizarDisciplinaDTO disciplina) {
		disciplinaRepository.save(DisciplinaDTO.transformaEmObjeto(disciplina));
	}
	
	/**
	 * Escuta eventos de remoção de disciplina advindos do serviço core
	 * @param id
	 */
	@JmsListener(destination = "disciplina.delete", containerFactory = "jmsFactoryTopic")
	public void onDisciplinaDelete(Long id) {
		disciplinaRepository.deleteById(id);
	}
}
