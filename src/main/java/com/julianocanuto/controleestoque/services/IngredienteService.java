package com.julianocanuto.controleestoque.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.dto.IngredienteDTO;
import com.julianocanuto.controleestoque.dto.IngredienteIdNomeQuantidadeDTO;
import com.julianocanuto.controleestoque.entidades.Ingrediente;
import com.julianocanuto.controleestoque.repositorios.IngredienteRepository;
import com.julianocanuto.controleestoque.repositorios.projections.IngredienteIdNomeQuantidadeProjection;

@Service
public class IngredienteService {
	
	@Autowired
	IngredienteRepository repository;
	
	@Transactional(readOnly = true)
	public List<Ingrediente> findAll(){
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Ingrediente> findAllPaged(Pageable pageable){
		return repository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public List<IngredienteIdNomeQuantidadeDTO> getIdNomeQuantidadeIngredientes() {
		List<IngredienteIdNomeQuantidadeProjection> list = repository.getIdNomeQuantidadeIngredientes();
		List<IngredienteIdNomeQuantidadeDTO> listDto = list.stream().map(x -> new IngredienteIdNomeQuantidadeDTO(x)).collect(Collectors.toList());
		return listDto;
	}

	@Transactional(readOnly = true)
	public IngredienteDTO findById(Long id) {
		Optional<Ingrediente> obj = repository.findById(id);
		Ingrediente entity = obj.get();
		IngredienteDTO ingredienteDTO = new IngredienteDTO(entity);
		return ingredienteDTO;
	}
	
	@Transactional
	public IngredienteDTO insert(IngredienteDTO ingredienteDTO) {
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setNome(ingredienteDTO.getNome());
		ingrediente.setUnidadeDeMedida(ingredienteDTO.getUnidadeDeMedida());
		ingrediente.setPrecoUnitario(ingredienteDTO.getPrecoUnitario());
		ingrediente = repository.save(ingrediente);
		return new IngredienteDTO(ingrediente);		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional
	public IngredienteDTO update(Long id, IngredienteDTO ingredienteDTO) {
		Ingrediente ingrediente= repository.getById(id);
		ingrediente.setNome(ingredienteDTO.getNome());
		ingrediente.setUnidadeDeMedida(ingredienteDTO.getUnidadeDeMedida());
		ingrediente.setPrecoUnitario(ingredienteDTO.getPrecoUnitario());
		ingrediente = repository.save(ingrediente);
		return new IngredienteDTO(ingrediente);
	}
	
}
