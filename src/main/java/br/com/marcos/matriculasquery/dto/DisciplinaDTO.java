package br.com.marcos.matriculasquery.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculasquery.dominio.Disciplina;
import br.com.marcos.matriculascore.dto.AtualizarDisciplinaDTO;
import br.com.marcos.matriculasquery.dominio.Professor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO que representa a disciplina
 * @author Marcos Macedo
 *
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DisciplinaDTO {

	@NotNull
	private Long id;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String sigla;
	
	@NotNull
	private Integer cargaHoraria;
	
	@NotNull
	private Long idProfessor;
	
	public static DisciplinaDTO transformaEmDTO(Disciplina disciplina) {
		return new DisciplinaDTO(disciplina.getId(), disciplina.getDescricao(), disciplina.getSigla(), disciplina.getCargaHoraria(), disciplina.getProfessor().getId());
	}
	
	public static List<DisciplinaDTO> transformaEmDTO(List<Disciplina> disciplinas) {
		return new ArrayList<>(disciplinas.stream()
				.map(disciplina -> transformaEmDTO(disciplina))
				.collect(Collectors.toList()));
	}
	
	public static Disciplina transformaEmObjeto(AtualizarDisciplinaDTO disciplinaDTO) {
		return new Disciplina(disciplinaDTO.getId(), disciplinaDTO.getDescricao(), disciplinaDTO.getSigla(), disciplinaDTO.getCargaHoraria(), new Professor(disciplinaDTO.getId()));
	}
}
