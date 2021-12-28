package com.julianocanuto.controleestoque.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocanuto.controleestoque.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
