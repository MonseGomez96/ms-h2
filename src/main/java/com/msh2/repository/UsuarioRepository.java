package com.msh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msh2.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
