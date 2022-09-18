package com.api.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.springboot.domain.Categoria;
import com.api.springboot.exceptions.ObjectNotFoundExceptions;
import com.api.springboot.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não encontrado: " + id +", Tipo: " + Categoria.class.getName() ));
	}
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setID(null);
		return categoriaRepository.save(obj);
		
	}
}
