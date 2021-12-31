package com.julianocanuto.controleestoque.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.julianocanuto.controleestoque.entidades.Produto;
import com.julianocanuto.controleestoque.repositorios.projections.ProdutoComIngredientesEMedidasParaCustoProjection;
import com.julianocanuto.controleestoque.repositorios.projections.ProdutoNomeQuantidadeProjection;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query(nativeQuery = true,
			value = "SELECT TB_PRODUTO.id, TB_PRODUTO.nome, TB_ESTOQUE.quantidade "
					+ "FROM TB_PRODUTO "
					+ "INNER JOIN TB_ESTOQUE "
					+ "ON TB_PRODUTO.estoque_id = TB_ESTOQUE.id")
	List<ProdutoNomeQuantidadeProjection> getNomeQuantidadeProdutos();
	
	@Query(nativeQuery = true, 
			value = "SELECT TB_PRODUTO.ID, TB_PRODUTO.NOME, TB_COMPONENTE.QUANTIDADE, TB_INGREDIENTE.PRECO_UNITARIO, TB_INGREDIENTE.UNIDADE_DE_MEDIDA "
					+ "FROM TB_PRODUTO "
					+ "INNER JOIN TB_COMPONENTE ON TB_PRODUTO.id = TB_COMPONENTE.produto_id "
					+ "INNER JOIN TB_INGREDIENTE ON TB_COMPONENTE.ingrediente_id = tb_ingrediente.id")
	List<ProdutoComIngredientesEMedidasParaCustoProjection> getProdutoComIngredientesEMedidasParaCusto();
}
