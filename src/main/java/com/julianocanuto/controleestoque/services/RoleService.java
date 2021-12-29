package com.julianocanuto.controleestoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.dto.RoleDTO;
import com.julianocanuto.controleestoque.entidades.Role;
import com.julianocanuto.controleestoque.repositorios.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository repository;
	
	@Transactional(readOnly = true)
	public Page<RoleDTO> findAllPaged(Pageable pageable){
		Page<Role> list = repository.findAll(pageable);
		return list.map(role -> new RoleDTO(role));
	}

}
