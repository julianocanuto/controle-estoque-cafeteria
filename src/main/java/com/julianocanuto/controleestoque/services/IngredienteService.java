package com.julianocanuto.controleestoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.entidades.Ingrediente;
import com.julianocanuto.controleestoque.repositorios.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	IngredienteRepository repository;
	
	@Transactional(readOnly = true)
	public List<Ingrediente> findAll(){
		return repository.findAll();
	}

}
