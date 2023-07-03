package com.msh2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msh2.entity.Usuario;
import com.msh2.repository.UsuarioRepository;

@Service
public class UsuarioServiceLogic implements UsuarioService {

	@Autowired
	UsuarioRepository repo;
	

	
	@Override
	public Usuario guardar(Usuario usuario) {
		
		Usuario usu = new Usuario();
	    usu.setNombre(usuario.getNombre());
	    usu.setApellido(usuario.getApellido());
	    usu.setTelefono(usuario.getTelefono());
	    usu.setDireccion(usuario.getDireccion());
	    
	    repo.save(usu);
		
		return usu;
	}

	@Override
	public Usuario editar(Usuario usuario) {
		
	   Usuario usu =repo.findById(usuario.getUsuarioId()).get();
	   usu.setNombre(usuario.getNombre());
	   usu.setApellido(usuario.getApellido());
	   usu.setTelefono(usuario.getTelefono());
	   usu.setDireccion(usuario.getDireccion());
	   
	   repo.save(usu);
	   
		return usu;
	}

	@Override
	public Optional<Usuario> buscar(Long id) {
	
		return repo.findById(id);
	}

	@Override
	public String eliminar(Long id) {
		repo.deleteById(id);
		return "Eliminado";
	}

	@Override
	public List mostrar() {
		
		return repo.findAll();
	}

	
}
