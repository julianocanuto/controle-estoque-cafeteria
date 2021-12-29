package com.julianocanuto.controleestoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julianocanuto.controleestoque.entidades.Role;
import com.julianocanuto.controleestoque.repositorios.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository repository;
	
	public List<Role> findAll(){
		return repository.findAll();
	}

}
