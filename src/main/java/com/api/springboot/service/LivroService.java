package com.api.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.springboot.domain.Livro;
import com.api.springboot.dtos.LivroDTO;
import com.api.springboot.exceptions.ObjectNotFoundExceptions;
import com.api.springboot.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundExceptions("Livro não encontrado: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return livroRepository.findAll();

	}

	public Livro create(Livro obj) {
		obj.setId(null);
		return livroRepository.save(obj);
	}

	public Livro update(Integer id, LivroDTO objDTO) {
		Livro obj = findById(id);
		obj.setTitulo(objDTO.getTitulo());
		obj.setNome_autor(objDTO.getNome_autor());
		obj.setTitulo(objDTO.getTitulo());
		return livroRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		livroRepository.deleteById(id);
	}
}
