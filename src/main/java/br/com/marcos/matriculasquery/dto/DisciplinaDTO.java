package br.com.marcos.matriculasquery.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.marcos.matriculascore.dominio.Disciplina;
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
public class DisciplinaDTO implements Serializable {
	
	private static final long serialVersionUID = 3L;

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
}
