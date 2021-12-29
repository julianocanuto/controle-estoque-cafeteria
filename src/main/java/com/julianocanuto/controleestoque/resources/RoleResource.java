package com.julianocanuto.controleestoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianocanuto.controleestoque.dto.RoleDTO;
import com.julianocanuto.controleestoque.services.RoleService;

@RestController
@RequestMapping(value = "/roles")
public class RoleResource {
	
	@Autowired
	private RoleService service;

	@GetMapping
	public ResponseEntity<Page<RoleDTO>> findAllPaged(Pageable pageable){
		Page<RoleDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
}
