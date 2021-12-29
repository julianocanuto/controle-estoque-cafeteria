package com.julianocanuto.controleestoque.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.julianocanuto.controleestoque.entidades.Ingrediente;

public class IngredienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo de preenchimento obrigatório")
	private String nome;

	@NotBlank(message = "Campo de preenchimento obrigatório")
	private String unidadeDeMedida;

	@Positive(message = "O preço deve ser um valor positivo")
	private Double precoUnitario;

	public IngredienteDTO() {

	}

	public IngredienteDTO(Long id, String nome, String unidadeDeMedida, Double precoUnitario) {
		this.id = id;
		this.nome = nome;
		this.unidadeDeMedida = unidadeDeMedida;
		this.precoUnitario = precoUnitario;
	}

	public IngredienteDTO(Ingrediente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.unidadeDeMedida = entity.getUnidadeDeMedida();
		this.precoUnitario = entity.getPrecoUnitario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

}
