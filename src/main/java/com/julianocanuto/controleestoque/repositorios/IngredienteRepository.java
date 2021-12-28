package com.julianocanuto.controleestoque.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocanuto.controleestoque.entidades.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{

}
