package com.julianocanuto.controleestoque.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.dto.IngredienteDTO;
import com.julianocanuto.controleestoque.dto.ProdutoDTO;
import com.julianocanuto.controleestoque.dto.ProdutoNomeQuantidadeDTO;
import com.julianocanuto.controleestoque.entidades.Ingrediente;
import com.julianocanuto.controleestoque.entidades.Produto;
import com.julianocanuto.controleestoque.repositorios.IngredienteRepository;
import com.julianocanuto.controleestoque.repositorios.ProdutoRepository;
import com.julianocanuto.controleestoque.repositorios.projections.ProdutoNomeQuantidadeProjection;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;
	
	@Autowired
	IngredienteRepository ingredienteRepository;

	@Transactional(readOnly = true)
	public List<ProdutoDTO> findAll() {
		List<Produto> list = repository.findAll();
		List<ProdutoDTO> listDTO = new ArrayList<>();
		for (Produto produto : list) {
			listDTO.add(new ProdutoDTO(produto));
		}
		return listDTO;
	}
	
	@Transactional(readOnly = true)
	public List<ProdutoNomeQuantidadeDTO> getNomeQuantidadeProdutos() {
		List<ProdutoNomeQuantidadeProjection> list = repository.getNomeQuantidadeProdutos();
		List<ProdutoNomeQuantidadeDTO> listDto = list.stream().map(x -> new ProdutoNomeQuantidadeDTO(x)).collect(Collectors.toList());
		return listDto;
	}

	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		Produto entity = obj.get();
		ProdutoDTO produtoDTO = new ProdutoDTO(entity);
		return produtoDTO;
	}
	
	@Transactional
	public ProdutoDTO insert(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		copyDtoToEntity(produtoDTO, produto);
		produto = repository.save(produto);
		return new ProdutoDTO(produto);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO produtoDTO) {
		Produto produto = repository.getById(id);
		copyDtoToEntity(produtoDTO, produto);
		produto = repository.save(produto);
		return new ProdutoDTO(produto);
	}

	private void copyDtoToEntity(ProdutoDTO dto, Produto entity) {
		entity.setNome(dto.getNome());
		entity.setPreco(dto.getPreco());
		entity.setImgUri(dto.getImgUri());
		
		entity.getIngredientes().clear();
		for(IngredienteDTO ingredienteDTO : dto.getIngredientes()) {
			Ingrediente ingrediente = ingredienteRepository.getById(ingredienteDTO.getId());
			entity.getIngredientes().add(ingrediente);
		}
	}

}
