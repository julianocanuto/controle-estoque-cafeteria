package com.julianocanuto.controleestoque.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julianocanuto.controleestoque.entidades.User;

@Repository
public interface UserRepository extends JpaRepository<User,	Long>{

	User findByEmail(String email);
}
