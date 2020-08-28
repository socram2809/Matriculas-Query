package br.com.marcos.matriculasquery.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.marcos.matriculascore.dominio.Professor;
import lombok.Getter;

/**
 * DTO que representa o retorno da criação/alteração de um professor
 * @author Marcos Macedo
 *
 */
@Getter
public class ProfessorDTO extends PessoaDTO implements Serializable {
	
	private static final long serialVersionUID = 2L;

	private ProfessorDTO(Long id, String nome, String email, String cpf, String titulacao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.titulacao = titulacao;
	}

	@NotBlank
	private String titulacao;
	
	public static ProfessorDTO transformaEmDTO(Professor professor) {
		return new ProfessorDTO(professor.getId(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getTitulacao());
	}
}
