package com.julianocanuto.controleestoque.entidades.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.julianocanuto.controleestoque.entidades.Ingrediente;
import com.julianocanuto.controleestoque.entidades.Produto;

@Embeddable
public class ComponentePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "ingrediente_id")
	private Ingrediente ingrediente;

	public ComponentePK() {

	}

	public ComponentePK(Produto produto, Ingrediente ingrediente) {
		this.produto = produto;
		this.ingrediente = ingrediente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingrediente, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentePK other = (ComponentePK) obj;
		return Objects.equals(ingrediente, other.ingrediente) && Objects.equals(produto, other.produto);
	}

}
