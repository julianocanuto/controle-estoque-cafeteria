package com.julianocanuto.controleestoque.dto;

import java.io.Serializable;

import com.julianocanuto.controleestoque.entidades.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String imgUri;
	private Double preco;

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
