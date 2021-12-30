package com.julianocanuto.controleestoque.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julianocanuto.controleestoque.entidades.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

}
