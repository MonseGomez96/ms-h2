package com.msh2.service;

import java.util.List;
import java.util.Optional;


import com.msh2.entity.Usuario;



public interface UsuarioService {
	
	Usuario guardar(Usuario usuario);
	
	Usuario editar(Usuario usuario );
	Optional <Usuario> buscar(Long id);
	String eliminar(Long id);
	List mostrar();
	

}
