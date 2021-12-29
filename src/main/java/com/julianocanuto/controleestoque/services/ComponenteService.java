package com.julianocanuto.controleestoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julianocanuto.controleestoque.entidades.Componente;
import com.julianocanuto.controleestoque.repositorios.ComponenteRepository;

@Service
public class ComponenteService {
	
	@Autowired
	ComponenteRepository repository;
	
	public List<Componente> findAll(){
		return repository.findAll();
	}

}
