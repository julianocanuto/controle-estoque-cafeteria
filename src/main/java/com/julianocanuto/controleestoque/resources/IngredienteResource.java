package com.julianocanuto.controleestoque.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<Ingrediente>> findAll(){
		List<Ingrediente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
