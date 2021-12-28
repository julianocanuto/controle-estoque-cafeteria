package com.julianocanuto.controleestoque.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julianocanuto.controleestoque.entidades.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,	Long>{

}
