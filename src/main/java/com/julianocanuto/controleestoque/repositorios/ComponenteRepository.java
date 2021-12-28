package com.julianocanuto.controleestoque.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocanuto.controleestoque.entidades.Componente;
import com.julianocanuto.controleestoque.entidades.pk.ComponentePK;

public interface ComponenteRepository extends JpaRepository<Componente,	ComponentePK>{

}
