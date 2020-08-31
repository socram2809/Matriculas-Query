package br.com.marcos.matriculasquery.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de domínio que representa uma disciplina
 * @author Marcos Macedo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Disciplina {
	
	/**
	 * Construtor para relacionamentos
	 * @param id
	 */
	public Disciplina(Long id) {
		this.id = id;
	}
	
	/**
	 * Identificador da disciplina
	 */
	@Id
	private Long id;
	
	/**
	 * Descrição da disciplina
	 */
	private String descricao;
	
	/**
	 * Sigla da disciplina
	 */
	private String sigla;
	
	/**
	 * Carga horária da disciplina
	 */
	private Integer cargaHoraria;
	
	/**
	 * Professor que ministrará a disciplica
	 */
	@ManyToOne(optional = false)
	private Professor professor;
}
