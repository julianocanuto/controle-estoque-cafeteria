package com.julianocanuto.controleestoque.dto;

import java.io.Serializable;

import com.julianocanuto.controleestoque.repositorios.projections.ProdutoNomeQuantidadeProjection;

public class ProdutoNomeQuantidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Integer quantidade;

	public ProdutoNomeQuantidadeDTO() {

	}

	public ProdutoNomeQuantidadeDTO(Long id, String nome, Integer quantidade) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public ProdutoNomeQuantidadeDTO(ProdutoNomeQuantidadeProjection projection) {
		id = projection.getId();
		nome = projection.getNome();
		quantidade = projection.getQuantidade();
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ProdutoNomeQuantidadeDTO [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + "]";
	}

}
