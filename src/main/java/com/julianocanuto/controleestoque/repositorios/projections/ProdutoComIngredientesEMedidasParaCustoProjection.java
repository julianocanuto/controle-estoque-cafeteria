package com.julianocanuto.controleestoque.repositorios.projections;

public interface ProdutoComIngredientesEMedidasParaCustoProjection {

	Long getIdProduto();
	String getNomeProduto();
	//String getNomeIngrediente();
	Double getQuantidadeIngrediente();
	Double getPrecoUnitarioIngrediente();
	String getUnidadeDeMedidaIngrediente();
}
