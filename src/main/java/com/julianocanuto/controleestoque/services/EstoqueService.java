package com.julianocanuto.controleestoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julianocanuto.controleestoque.dto.EstoqueDTO;
import com.julianocanuto.controleestoque.entidades.Estoque;
import com.julianocanuto.controleestoque.repositorios.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	EstoqueRepository repository;

	@Transactional(readOnly = true)
	public Page<EstoqueDTO> findAllPaged(Pageable pageable) {
		Page<Estoque> list = repository.findAll(pageable);
		Page<EstoqueDTO> listDto = list.map(x -> new EstoqueDTO(x));
		return listDto;
	}

	@Transactional
	public EstoqueDTO insert(EstoqueDTO dto) {
		Estoque entity = new Estoque();
		entity.setEstocavelTipo(dto.getEstocavelTipo());
		entity.setEstocavelId(dto.getEstocavelId());
		
		if (dto.getOperacaoNoEstoque().equals("saida")) {
			entity.setQuantidade(dto.getQuantidade() * -1);
		} else {
			entity.setQuantidade(dto.getQuantidade());
		}
		
		entity.setOperacaoNoEstoque(dto.getOperacaoNoEstoque());
		entity.setEstocavelUnidadeDeMedida(dto.getEstocavelUnidadeDeMedida());
		entity = repository.save(entity);
		return new EstoqueDTO(entity);
	}

}
