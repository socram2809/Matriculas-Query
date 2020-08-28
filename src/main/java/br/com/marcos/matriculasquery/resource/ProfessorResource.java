package br.com.marcos.matriculasquery.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.matriculascore.dto.AtualizarProfessorDTO;
import br.com.marcos.matriculasquery.dto.ProfessorDTO;
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
	 * Processa requisições que utilizam o método GET do HTTP para retornar todos os professores
	 * @return
	 */
	@GetMapping
	public List<ProfessorDTO> recuperarProfessores(){
		return ProfessorDTO.transformaEmDTO(professorRepository.findAll());
	}
	
	/**
	 * Escuta eventos de criação/alteração de professor advindos do serviço core
	 * @param aluno
	 */
	@JmsListener(destination = "professor.update", containerFactory = "jmsFactoryTopic")
	public void onProfessorUpdate(AtualizarProfessorDTO professor) {
		professorRepository.save(ProfessorDTO.transformaEmObjeto(professor));
	}
	
	/**
	 * Escuta eventos de remoção de professor advindos do serviço core
	 * @param id
	 */
	@JmsListener(destination = "professor.delete", containerFactory = "jmsFactoryTopic")
	public void onProfessorDelete(Long id) {
		professorRepository.deleteById(id);
	}
}
