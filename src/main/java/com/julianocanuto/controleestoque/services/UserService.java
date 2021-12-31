package com.julianocanuto.controleestoque.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.dto.RoleDTO;
import com.julianocanuto.controleestoque.dto.UserDTO;
import com.julianocanuto.controleestoque.entidades.Role;
import com.julianocanuto.controleestoque.entidades.User;
import com.julianocanuto.controleestoque.repositorios.RoleRepository;
import com.julianocanuto.controleestoque.repositorios.UserRepository;
import com.julianocanuto.controleestoque.services.exceptions.DatabaseException;
import com.julianocanuto.controleestoque.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> list = repository.findAll(pageable);
		return list.map(user -> new UserDTO(user));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {

		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id " + id + " não encontrado");
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id " + id + " not found");

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));

		entity.getRoles().clear();
		for (RoleDTO roleDTO : dto.getRoles()) {
			Role role = roleRepository.getById(roleDTO.getId());
			entity.getRoles().add(role);
		}
	}

}
