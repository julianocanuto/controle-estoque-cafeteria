package com.julianocanuto.controleestoque.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianocanuto.controleestoque.entidades.Componente;
import com.julianocanuto.controleestoque.services.ComponenteService;

@RestController
@RequestMapping(value = "/componentes")
public class ComponenteResource {
	
	@Autowired
	private ComponenteService service;

	@GetMapping
	public ResponseEntity<List<Componente>> findAll(){
		List<Componente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
