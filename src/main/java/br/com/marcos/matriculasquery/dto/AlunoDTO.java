package br.com.marcos.matriculasquery.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dto.AtualizarAlunoDTO;
import br.com.marcos.matriculasquery.dominio.Aluno;
import br.com.marcos.matriculasquery.dto.AlunoDTO;
import lombok.Getter;

/**
 * DTO que representa o aluno
 * @author Marcos Macedo
 *
 */
@Getter
public class AlunoDTO extends PessoaDTO {

	private AlunoDTO(Long id, String nome, String email, String cpf, Integer matricula, String formaIngresso) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
	}

	@NotNull
	private Integer matricula;
	
	@NotBlank
	private String formaIngresso;
	
	private static AlunoDTO transformaEmDTO(Aluno aluno) {
		return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf(), aluno.getMatricula(), aluno.getFormaIngresso());
	}
	
	public static List<AlunoDTO> transformaEmDTO(List<Aluno> alunos) {
		return new ArrayList<>(alunos.stream()
				.map(aluno -> transformaEmDTO(aluno))
				.collect(Collectors.toList()));
	}
	
	public static Aluno transformaEmObjeto(AtualizarAlunoDTO alunoDTO) {
		return new Aluno(alunoDTO.getId(), alunoDTO.getNome(), alunoDTO.getEmail(), alunoDTO.getCpf(), alunoDTO.getMatricula(), alunoDTO.getFormaIngresso());
	}
}
