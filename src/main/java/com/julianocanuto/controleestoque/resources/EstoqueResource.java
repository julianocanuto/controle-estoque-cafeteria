package com.julianocanuto.controleestoque.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.julianocanuto.controleestoque.dto.IngredienteIdNomeQuantidadeDTO;
import com.julianocanuto.controleestoque.dto.ProdutoNomeQuantidadeDTO;
import com.julianocanuto.controleestoque.services.IngredienteService;
import com.julianocanuto.controleestoque.services.ProdutoService;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueResource {

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private IngredienteService ingredienteService;

	@GetMapping(value = "/produtos")
	public ResponseEntity<List<ProdutoNomeQuantidadeDTO>> getNomeQuantidadeProdutos() {
		List<ProdutoNomeQuantidadeDTO> listDto = service.getNomeQuantidadeProdutos();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/ingredientes")
	public ResponseEntity<List<IngredienteIdNomeQuantidadeDTO>> getIdNomeQuantidadeIngredientes() {
		List<IngredienteIdNomeQuantidadeDTO> listDto = ingredienteService.getIdNomeQuantidadeIngredientes();
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/produtos/{idProduto}")
	public ResponseEntity<Boolean> podeSerVendido(@PathVariable Long idProduto,
			@RequestParam("quantidadeDesejada") Integer quantidadeDesejada) {
		Boolean podeSerVendido = false;
		ProdutoNomeQuantidadeDTO produtoDesejado = new ProdutoNomeQuantidadeDTO();
		List<ProdutoNomeQuantidadeDTO> listDto = service.getNomeQuantidadeProdutos();
		for (ProdutoNomeQuantidadeDTO produto : listDto) {
			if (produto.getId() == idProduto) {
				produtoDesejado = produto;
			}
		}
		if (produtoDesejado.getQuantidade() >= quantidadeDesejada) {
			podeSerVendido = true;
		}

		return ResponseEntity.ok().body(podeSerVendido);
	}

}
