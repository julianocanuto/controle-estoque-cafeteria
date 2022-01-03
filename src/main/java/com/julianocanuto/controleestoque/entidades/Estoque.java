package com.julianocanuto.controleestoque.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estoque")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long estocavelId;
	private Double quantidade;
	private String operacaoNoEstoque;
	private String estocavelTipo;
	private String estocavelUnidadeDeMedida;

	public Estoque() {

	}

	public Estoque(Long id, Long estocavelId, Double quantidade, String operacaoNoEstoque, String estocavelTipo,
			String estocavelUnidadeDeMedida) {
		this.id = id;
		this.estocavelId = estocavelId;
		this.quantidade = quantidade;
		this.operacaoNoEstoque = operacaoNoEstoque;
		this.estocavelTipo = estocavelTipo;
		this.estocavelUnidadeDeMedida = estocavelUnidadeDeMedida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEstocavelId() {
		return estocavelId;
	}

	public void setEstocavelId(Long estocavelId) {
		this.estocavelId = estocavelId;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getOperacaoNoEstoque() {
		return operacaoNoEstoque;
	}

	public void setOperacaoNoEstoque(String operacaoNoEstoque) {
		this.operacaoNoEstoque = operacaoNoEstoque;
	}

	public String getEstocavelTipo() {
		return estocavelTipo;
	}

	public void setEstocavelTipo(String estocavelTipo) {
		this.estocavelTipo = estocavelTipo;
	}

	public String getEstocavelUnidadeDeMedida() {
		return estocavelUnidadeDeMedida;
	}

	public void setEstocavelUnidadeDeMedida(String estocavelUnidadeDeMedida) {
		this.estocavelUnidadeDeMedida = estocavelUnidadeDeMedida;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", estocavelId=" + estocavelId + ", quantidade=" + quantidade
				+ ", operacaoNoEstoque=" + operacaoNoEstoque + ", estocavelTipo=" + estocavelTipo
				+ ", estocavelUnidadeDeMedida=" + estocavelUnidadeDeMedida + "]";
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
