package com.msh2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msh2.entity.Usuario;
import com.msh2.service.UsuarioServiceLogic;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceLogic service;
	
	//Mostrar
	@GetMapping
	public ResponseEntity<List<Usuario>> mostrar(){
		
		List<Usuario> usuario = service.mostrar();
		if(usuario.size()>0) {
			return new ResponseEntity<List<Usuario>>(usuario,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.NO_CONTENT);
		}
		
	}
	
	//Buscar
	@GetMapping("buscar-por-id/{id}")
	public ResponseEntity<Usuario>buscar(@PathVariable("id")Long id){
		Optional<Usuario> usuario = service.buscar(id);
		if(usuario != null) {
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	//Guardar
	@PostMapping("/guardar")
	public ResponseEntity<Usuario>guardar(@RequestBody Usuario usuario){
		Usuario usu = service.guardar(usuario);
		if(usu!=null) {
			return new ResponseEntity<Usuario>(usu, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Editar
	@PutMapping
	public ResponseEntity<Usuario>editar(@RequestBody Usuario usuario){
		Usuario usu = service.editar(usuario);
		if(usu!=null) {
			return new ResponseEntity<>(usu, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	//Eliminar
	@DeleteMapping("borrar/{id}")
	public ResponseEntity<String>eliminar(@PathVariable("id")Long id){
		String mensaje = service.eliminar(id);
		if(mensaje != null) {
			return new ResponseEntity<String>(mensaje, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}



}
