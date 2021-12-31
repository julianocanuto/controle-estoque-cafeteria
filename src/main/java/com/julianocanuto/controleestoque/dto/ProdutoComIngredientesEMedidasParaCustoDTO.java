package com.julianocanuto.controleestoque.dto;

import java.io.Serializable;

import com.julianocanuto.controleestoque.repositorios.projections.ProdutoComIngredientesEMedidasParaCustoProjection;

public class ProdutoComIngredientesEMedidasParaCustoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idProduto;
	private String nomeProduto;
	private Double quantidadeIngrediente;
	private Double precoUnitarioIngrediente;
	private String unidadeDeMedidaIngrediente;

	public ProdutoComIngredientesEMedidasParaCustoDTO() {

	}

	public ProdutoComIngredientesEMedidasParaCustoDTO(Long idProduto, String nomeProduto, Double quantidadeIngrediente, 
			Double precoUnitarioIngrediente, String unidadeDeMedidaIngrediente) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.quantidadeIngrediente = quantidadeIngrediente;
		this.precoUnitarioIngrediente = precoUnitarioIngrediente;
		this.unidadeDeMedidaIngrediente = unidadeDeMedidaIngrediente;
	}

	public ProdutoComIngredientesEMedidasParaCustoDTO(ProdutoComIngredientesEMedidasParaCustoProjection projection) {
		idProduto = projection.getIdProduto();
		nomeProduto = projection.getNomeProduto();
		quantidadeIngrediente = projection.getQuantidadeIngrediente();
		precoUnitarioIngrediente = projection.getPrecoUnitarioIngrediente();
		unidadeDeMedidaIngrediente = projection.getUnidadeDeMedidaIngrediente();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getQuantidadeIngrediente() {
		return quantidadeIngrediente;
	}

	public void setQuantidadeIngrediente(Double quantidadeIngrediente) {
		this.quantidadeIngrediente = quantidadeIngrediente;
	}

	public Double getPrecoUnitarioIngrediente() {
		return precoUnitarioIngrediente;
	}

	public void setPrecoUnitarioIngrediente(Double precoUnitarioIngrediente) {
		this.precoUnitarioIngrediente = precoUnitarioIngrediente;
	}

	public String getUnidadeDeMedidaIngrediente() {
		return unidadeDeMedidaIngrediente;
	}

	public void setUnidadeDeMedidaIngrediente(String unidadeDeMedidaIngrediente) {
		this.unidadeDeMedidaIngrediente = unidadeDeMedidaIngrediente;
	}

	@Override
	public String toString() {
		return "ProdutoComIngredientesEMedidasParaCustoDTO [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto
				+ ", quantidadeIngrediente=" + quantidadeIngrediente
				+ ", precoUnitarioIngrediente=" + precoUnitarioIngrediente + ", unidadeDeMedidaIngrediente="
				+ unidadeDeMedidaIngrediente + "]";
	}

}
