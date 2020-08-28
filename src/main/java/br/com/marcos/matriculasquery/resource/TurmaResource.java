package br.com.marcos.matriculasquery.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.matriculascore.dto.AtualizarTurmaDTO;
import br.com.marcos.matriculasquery.dto.TurmaDTO;
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
	 * Processa requisições que utilizam o método GET do HTTP para retornar todas as turmas
	 * @return
	 */
	@GetMapping
	public List<TurmaDTO> recuperarTurmas(){
		return TurmaDTO.transformaEmDTO(turmaRepository.findAll());
	}
	
	/**
	 * Escuta eventos de criação/alteração de turma advindos do serviço core
	 * @param turma
	 */
	@JmsListener(destination = "turma.update", containerFactory = "jmsFactoryTopic")
	public void onTurmaUpdate(AtualizarTurmaDTO turma) {
		turmaRepository.save(TurmaDTO.transformaEmObjeto(turma));
	}
	
	/**
	 * Escuta eventos de remoção de turma advindos do serviço core
	 * @param id
	 */
	@JmsListener(destination = "turma.delete", containerFactory = "jmsFactoryTopic")
	public void onTurmaDelete(Long id) {
		turmaRepository.deleteById(id);
	}
}
