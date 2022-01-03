package com.julianocanuto.controleestoque.dto;

import java.io.Serializable;
import java.util.Objects;

import com.julianocanuto.controleestoque.entidades.Estocavel;

public class EstocavelDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipo;
	private String unidadeDeMedida;

	public EstocavelDTO() {

	}

	public EstocavelDTO(Long id, String tipo, String unidadeDeMedida) {
		this.id = id;
		this.tipo = tipo;
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	public EstocavelDTO(Estocavel entity) {
		id = entity.getId();
		tipo = entity.getTipo();
		unidadeDeMedida = entity.getUnidadeDeMedida();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipo, unidadeDeMedida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstocavelDTO other = (EstocavelDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(unidadeDeMedida, other.unidadeDeMedida);
	}

}
