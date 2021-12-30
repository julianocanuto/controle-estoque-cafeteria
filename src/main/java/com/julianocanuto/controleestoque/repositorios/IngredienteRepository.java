package com.julianocanuto.controleestoque.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.julianocanuto.controleestoque.entidades.Ingrediente;
import com.julianocanuto.controleestoque.repositorios.projections.IngredienteIdNomeQuantidadeProjection;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{

	@Query(nativeQuery = true,
			value = "SELECT TB_INGREDIENTE.id TB_INGREDIENTE.nome, TB_ESTOQUE.quantidade "
					+ "FROM TB_INGREDIENTE "
					+ "INNER JOIN TB_ESTOQUE ON TB_INGREDIENTE.estoque_id = TB_ESTOQUE.id")
	List<IngredienteIdNomeQuantidadeProjection> getIdNomeQuantidadeIngredientes();
}
