package com.julianocanuto.controleestoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.entidades.User;
import com.julianocanuto.controleestoque.repositorios.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<User> findAll(){
		return repository.findAll();
	}

}
