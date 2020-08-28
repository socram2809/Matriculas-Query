package br.com.marcos.matriculasquery.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.marcos.matriculasquery.dominio.Professor;
import br.com.marcos.matriculascore.dto.AtualizarProfessorDTO;
import lombok.Getter;

/**
 * DTO que representa o professor
 * @author Marcos Macedo
 *
 */
@Getter
public class ProfessorDTO extends PessoaDTO{

	private ProfessorDTO(Long id, String nome, String email, String cpf, String titulacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.titulacao = titulacao;
	}

	@NotBlank
	private String titulacao;
	
	private static ProfessorDTO transformaEmDTO(Professor professor) {
		return new ProfessorDTO(professor.getId(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getTitulacao());
	}
	
	public static List<ProfessorDTO> transformaEmDTO(List<Professor> professores) {
		return new ArrayList<>(professores.stream()
				.map(professor -> transformaEmDTO(professor))
				.collect(Collectors.toList()));
	}
	
	public static Professor transformaEmObjeto(AtualizarProfessorDTO professorDTO) {
		return new Professor(professorDTO.getId(), professorDTO.getNome(), professorDTO.getEmail(), professorDTO.getCpf(), professorDTO.getTitulacao());
	}
}
