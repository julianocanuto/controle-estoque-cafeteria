package com.julianocanuto.controleestoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.entidades.Produto;
import com.julianocanuto.controleestoque.repositorios.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Produto> findAll(){
		return repository.findAll();
	}

}
