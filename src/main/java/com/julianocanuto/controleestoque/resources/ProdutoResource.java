package com.julianocanuto.controleestoque.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianocanuto.controleestoque.dto.ProdutoDTO;
import com.julianocanuto.controleestoque.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll(){
		List<ProdutoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
