package com.julianocanuto.controleestoque.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.julianocanuto.controleestoque.entidades.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(min = 3, message = "O nome do produto deve possuir pelo menos 3 caracteres")
	@NotBlank(message = "Campo de preenchimento obrigatório")
	private String nome;
	private String imgUri;
	
	@Positive(message = "O preço deve ser um valor positivo")
	private Double preco;
	
	private Set<IngredienteDTO> ingredientes = new HashSet<>();

	public ProdutoDTO() {

	}

	public ProdutoDTO(Long id, String nome, String imgUri, Double preco) {
		this.id = id;
		this.nome = nome;
		this.imgUri = imgUri;
		this.preco = preco;
	}
	
	public ProdutoDTO(Produto entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.imgUri = entity.getImgUri();
		this.preco = entity.getPreco();
		entity.getIngredientes().forEach(ingrediente -> this.ingredientes.add(new IngredienteDTO(ingrediente)));
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

	public String getImgUri() {
		return imgUri;
	}

	public void setImgUri(String imgUri) {
		this.imgUri = imgUri;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
