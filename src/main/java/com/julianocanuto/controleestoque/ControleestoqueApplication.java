package com.julianocanuto.controleestoque;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.julianocanuto.controleestoque.dto.ProdutoNomeQuantidadeDTO;
import com.julianocanuto.controleestoque.repositorios.ProdutoRepository;
import com.julianocanuto.controleestoque.repositorios.projections.ProdutoNomeQuantidadeProjection;

@SpringBootApplication
public class ControleestoqueApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ControleestoqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<ProdutoNomeQuantidadeProjection> list = produtoRepository.getNomeQuantidadeProdutos();
		List<ProdutoNomeQuantidadeDTO> listDto = list.stream().map(x -> new ProdutoNomeQuantidadeDTO(x))
				.collect(Collectors.toList());

		for (ProdutoNomeQuantidadeDTO obj : listDto) {
			System.out.println(obj);
		}
	}

}
