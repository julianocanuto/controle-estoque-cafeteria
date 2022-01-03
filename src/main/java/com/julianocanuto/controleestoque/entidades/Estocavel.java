package com.julianocanuto.controleestoque.entidades;

public class Estocavel {

	Long id;
	String tipo;
	String unidadeDeMedida;

	public Estocavel() {

	}

	public Estocavel(Long id, String tipo, String unidadeDeMedida) {
		this.id = id;
		this.tipo = tipo;
		this.unidadeDeMedida = unidadeDeMedida;
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

}
