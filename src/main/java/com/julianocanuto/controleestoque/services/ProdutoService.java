package com.julianocanuto.controleestoque.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.dto.ProdutoDTO;
import com.julianocanuto.controleestoque.entidades.Produto;
import com.julianocanuto.controleestoque.repositorios.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

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
	public ProdutoDTO findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		Produto entity = obj.get();
		ProdutoDTO produtoDTO = new ProdutoDTO(entity);
		return produtoDTO;
	}
	
	@Transactional
	public ProdutoDTO insert(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		produto.setNome(produtoDTO.getNome());
		produto.setPreco(produtoDTO.getPreco());
		produto.setImgUri(produtoDTO.getImgUri());
		produto = repository.save(produto);
		return new ProdutoDTO(produto);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
