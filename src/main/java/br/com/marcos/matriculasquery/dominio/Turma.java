package br.com.marcos.matriculasquery.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe de domínio que representa uma turma
 * @author Marcos Macedo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Turma {
	
	/**
	 * Identificador da turma
	 */
	@Id
	private Long id;

	/**
	 * Descrição da turma
	 */
	private String descricao;
	
	/**
	 * Ano Letivo da Turma
	 */
	private Integer anoLetivo;
	
	/**
	 * Período Letivo da Turma
	 */
	private Integer periodoLetivo;
	
	/**
	 * Número de Vagas da Turma
	 */
	private Integer numeroVagas;
	
	/**
	 * Disciplinas da Turma
	 */
	@ManyToMany
	@JoinTable(name = "turma_disciplinas")
	private List<Disciplina> disciplinas;
	
	/**
	 * Alunos da Turma
	 */
	@ManyToMany
	@JoinTable(name = "turma_alunos")
	private List<Aluno> alunos;
}
