package com.julianocanuto.controleestoque.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.julianocanuto.controleestoque.dto.ProdutoDTO;
import com.julianocanuto.controleestoque.dto.ProdutoNomeQuantidadeDTO;
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
	
	@GetMapping(value = "/estoque")
	public ResponseEntity<List<ProdutoNomeQuantidadeDTO>> getNomeQuantidadeProdutos(){
		List<ProdutoNomeQuantidadeDTO> listDto = service.getNomeQuantidadeProdutos();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
		ProdutoDTO produtoDTO = service.findById(id);
		return ResponseEntity.ok().body(produtoDTO);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> insert(@Valid @RequestBody ProdutoDTO produtoDTO){
		produtoDTO = service.insert(produtoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produtoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(produtoDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO) {
		produtoDTO = service.update(id, produtoDTO);

		return ResponseEntity.ok().body(produtoDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}
}
