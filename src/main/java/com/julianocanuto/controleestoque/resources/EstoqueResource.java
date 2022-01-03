package com.julianocanuto.controleestoque.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.julianocanuto.controleestoque.dto.EstoqueDTO;
import com.julianocanuto.controleestoque.dto.IngredienteIdNomeQuantidadeDTO;
import com.julianocanuto.controleestoque.dto.ProdutoComIngredientesEMedidasParaCustoDTO;
import com.julianocanuto.controleestoque.dto.ProdutoNomeQuantidadeDTO;
import com.julianocanuto.controleestoque.dto.ProdutoVendavelDTO;
import com.julianocanuto.controleestoque.services.EstoqueService;
import com.julianocanuto.controleestoque.services.IngredienteService;
import com.julianocanuto.controleestoque.services.ProdutoService;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueResource {

	@Autowired
	private ProdutoService service;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private EstoqueService estoqueService;
 
	@GetMapping
	public ResponseEntity<Page<EstoqueDTO>> getItensNoEstoque(Pageable pageable) {
		Page<EstoqueDTO> listDto = estoqueService.findAllPaged(pageable);
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<EstoqueDTO> insertItemNoEstoque(@RequestBody EstoqueDTO dto) {
		EstoqueDTO newDto = estoqueService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}
	
	@GetMapping(value = "/produtos")
	public ResponseEntity<List<ProdutoNomeQuantidadeDTO>> getNomeQuantidadeProdutos() {
		List<ProdutoNomeQuantidadeDTO> listDto = service.getNomeQuantidadeProdutos();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/produtos/custo")
	public ResponseEntity<List<ProdutoComIngredientesEMedidasParaCustoDTO>> getCustoDosProdutos() {
		List<ProdutoComIngredientesEMedidasParaCustoDTO> listDto = service.getProdutoComIngredientesEMedidasParaCusto();
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/ingredientes")
	public ResponseEntity<List<IngredienteIdNomeQuantidadeDTO>> getIdNomeQuantidadeIngredientes() {
		List<IngredienteIdNomeQuantidadeDTO> listDto = ingredienteService.getIdNomeQuantidadeIngredientes();
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/produtos/{idProduto}")
	public ResponseEntity<ProdutoVendavelDTO> podeSerVendido(@PathVariable Long idProduto,
			@RequestParam("quantidadeDesejada") Integer quantidadeDesejada) {
		
		ProdutoVendavelDTO podeSerVendido = new ProdutoVendavelDTO(false);
		ProdutoNomeQuantidadeDTO produtoDesejado = new ProdutoNomeQuantidadeDTO();
		List<ProdutoNomeQuantidadeDTO> listDto = service.getNomeQuantidadeProdutos();
		for (ProdutoNomeQuantidadeDTO produto : listDto) {
			if (produto.getId() == idProduto) {
				produtoDesejado = produto;
			}
		}
		if (produtoDesejado.getQuantidade() >= quantidadeDesejada) {
			podeSerVendido.setIsVendavel(true);
		}

		return ResponseEntity.ok().body(podeSerVendido);
	}

}
