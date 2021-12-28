package com.julianocanuto.controleestoque.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocanuto.controleestoque.entidades.User;

public interface UserRepository extends JpaRepository<User,	Long>{

}
