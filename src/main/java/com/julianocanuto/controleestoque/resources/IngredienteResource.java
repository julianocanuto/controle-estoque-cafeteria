package com.julianocanuto.controleestoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
