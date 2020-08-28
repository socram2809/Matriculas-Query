package br.com.marcos.matriculasquery.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.matriculascore.dto.AtualizarAlunoDTO;
import br.com.marcos.matriculasquery.dto.AlunoDTO;
import br.com.marcos.matriculasquery.repository.AlunoRepository;

/**
 * Controlador REST que mapeia a URI "/aluno" para ser processada
 * @author Marcos Macedo
 *
 */
@RestController
@RequestMapping("/aluno")
public class AlunoResource {
	
	/**
	 * Injeção de dependência para utilizar o repositório de Aluno
	 */
	@Autowired
	private AlunoRepository alunoRepository;
	
	/**
	 * Processa requisições que utilizam o método GET do HTTP para retornar todos os alunos
	 * @return
	 */
	@GetMapping
	public List<AlunoDTO> recuperarAlunos(){
		return AlunoDTO.transformaEmDTO(alunoRepository.findAll());
	}
	
	/**
	 * Escuta eventos de criação/alteração de aluno advindos do serviço core
	 * @param aluno
	 */
	@JmsListener(destination = "aluno.update", containerFactory = "jmsFactoryTopic")
	public void onAlunoUpdate(AtualizarAlunoDTO aluno) {
		alunoRepository.save(AlunoDTO.transformaEmObjeto(aluno));
	}
	
	/**
	 * Escuta eventos de remoção de aluno advindos do serviço core
	 * @param id
	 */
	@JmsListener(destination = "aluno.delete", containerFactory = "jmsFactoryTopic")
	public void onAlunoDelete(Long id) {
		alunoRepository.deleteById(id);
	}
}
