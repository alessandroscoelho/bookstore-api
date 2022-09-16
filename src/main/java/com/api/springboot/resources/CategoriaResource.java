package com.api.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.domain.Categoria;
import com.api.springboot.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
	
		Categoria obj = categoriaService.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
}
// aula: https://www.youtube.com/watch?v=3Ya9EmZYXl4&list=PLA8Qj9w4RGkVOj-xGYJCHJ0Ob4CMg-8NI&index=12&ab_channel=ValdirCezarTutoriais