package com.julianocanuto.controleestoque.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julianocanuto.controleestoque.entidades.Componente;
import com.julianocanuto.controleestoque.entidades.pk.ComponentePK;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente,	ComponentePK>{

}
