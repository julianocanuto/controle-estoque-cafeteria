package com.julianocanuto.controleestoque.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estoque")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "estoque")
	private List<Produto> produtosEmEstoque = new ArrayList<>();
	
	@OneToMany(mappedBy = "estoque")
	private List<Ingrediente> ingredientesEmEstoque = new ArrayList<>();
	
	private Integer quantidade;

	public Estoque() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtosEmEstoque;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtosEmEstoque = produtos;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		return Objects.equals(id, other.id);
	}

}
