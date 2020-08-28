package br.com.marcos.matriculasquery.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dto.AtualizarTurmaDTO;
import br.com.marcos.matriculasquery.dominio.Turma;
import br.com.marcos.matriculasquery.dominio.Disciplina;
import br.com.marcos.matriculasquery.dominio.Aluno;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO que representa a turma
 * @author Marcos Macedo
 *
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TurmaDTO {

	@NotNull
	private Long id;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private Integer anoLetivo;
	
	@NotNull
	private Integer periodoLetivo;
	
	@NotNull
	private Integer numeroVagas;
	
	@NotEmpty
	private List<Long> disciplinas;
	
	@NotEmpty
	private List<Long> alunos;
	
	private static TurmaDTO transformaEmDTO(Turma turma) {
		return new TurmaDTO(turma.getId(), turma.getDescricao(), turma.getAnoLetivo(), turma.getPeriodoLetivo(), turma.getNumeroVagas(), 
				turma.getDisciplinas().stream().mapToLong(Disciplina::getId).boxed().collect(Collectors.toList()), 
				turma.getAlunos().stream().mapToLong(Aluno::getId).boxed().collect(Collectors.toList()));
	}
	
	public static List<TurmaDTO> transformaEmDTO(List<Turma> turmas) {
		return new ArrayList<>(turmas.stream()
				.map(turma -> transformaEmDTO(turma))
				.collect(Collectors.toList()));
	}
	
	public static Turma transformaEmObjeto(AtualizarTurmaDTO turmaDTO) {
		return new Turma(turmaDTO.getId(), turmaDTO.getDescricao(), turmaDTO.getAnoLetivo(), turmaDTO.getPeriodoLetivo(), turmaDTO.getNumeroVagas(), 
				turmaDTO.getDisciplinas().stream().map(idDisciplina -> new Disciplina(idDisciplina)).collect(Collectors.toList()), 
				turmaDTO.getAlunos().stream().map(idAluno -> new Aluno(idAluno)).collect(Collectors.toList()));
	}
}
