package com.julianocanuto.controleestoque.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.julianocanuto.controleestoque.dto.IngredienteDTO;
import com.julianocanuto.controleestoque.entidades.Ingrediente;
import com.julianocanuto.controleestoque.services.IngredienteService;

@RestController
@RequestMapping(value = "/ingredientes")
public class IngredienteResource {

	@Autowired
	private IngredienteService service;

	@GetMapping
	public ResponseEntity<Page<Ingrediente>> findAll(Pageable pageable) {
		Page<Ingrediente> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<IngredienteDTO> findById(@PathVariable Long id) {
		IngredienteDTO ingredienteDTO = service.findById(id);
		return ResponseEntity.ok().body(ingredienteDTO);
	}

	@PostMapping
	public ResponseEntity<IngredienteDTO> insert(@Valid @RequestBody IngredienteDTO ingredienteDTO) {
		ingredienteDTO = service.insert(ingredienteDTO);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(ingredienteDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(ingredienteDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<IngredienteDTO> update(@PathVariable Long id, @Valid @RequestBody IngredienteDTO ingredienteDTO) {
		ingredienteDTO = service.update(id, ingredienteDTO);

		return ResponseEntity.ok().body(ingredienteDTO);
	}
}
