package com.julianocanuto.controleestoque.dto;

import com.julianocanuto.controleestoque.repositorios.projections.ProdutoNomeQuantidadeProjection;

public class ProdutoNomeQuantidadeDTO {

	private String nome;
	private Integer quantidade;

	public ProdutoNomeQuantidadeDTO() {

	}

	public ProdutoNomeQuantidadeDTO(String nome, Integer quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public ProdutoNomeQuantidadeDTO(ProdutoNomeQuantidadeProjection projection) {
		nome = projection.getNome();
		quantidade = projection.getQuantidade();
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
		return "ProdutoNomeQuantidadeDTO [nome=" + nome + ", quantidade=" + quantidade + "]";
	}

}
