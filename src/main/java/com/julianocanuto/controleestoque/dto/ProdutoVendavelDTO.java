package com.julianocanuto.controleestoque.dto;

import java.io.Serializable;

public class ProdutoVendavelDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean isVendavel;

	public ProdutoVendavelDTO() {

	}

	public ProdutoVendavelDTO(Boolean isVendavel) {
		super();
		this.isVendavel = isVendavel;
	}

	public Boolean getIsVendavel() {
		return isVendavel;
	}

	public void setIsVendavel(Boolean isVendavel) {
		this.isVendavel = isVendavel;
	}

}
