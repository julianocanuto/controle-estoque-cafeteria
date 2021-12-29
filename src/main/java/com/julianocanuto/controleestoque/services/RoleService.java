package com.julianocanuto.controleestoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.entidades.Role;
import com.julianocanuto.controleestoque.repositorios.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository repository;
	
	@Transactional(readOnly = true)
	public List<Role> findAll(){
		return repository.findAll();
	}

}
