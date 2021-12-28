package com.julianocanuto.controleestoque.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.julianocanuto.controleestoque.entidades.pk.ComponentePK;

@Entity
@Table(name = "tb_componente")
public class Componente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComponentePK id = new ComponentePK();
	private Double quantidade;

	public Componente() {

	}

	public Componente(Produto produto, Ingrediente ingrediente, Double quantidade) {
		id.setProduto(produto);
		id.setIngrediente(ingrediente);
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Ingrediente getIngrediente() {
		return id.getIngrediente();
	}

	public void setIngrediente(Ingrediente ingrediente) {
		id.setIngrediente(ingrediente);
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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
		Componente other = (Componente) obj;
		return Objects.equals(id, other.id);
	}

}
