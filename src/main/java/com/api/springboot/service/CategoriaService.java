package com.api.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.springboot.domain.Categoria;
import com.api.springboot.dtos.CategoriaDTO;
import com.api.springboot.exceptions.ObjectNotFoundExceptions;
import com.api.springboot.repository.CategoriaRepository;
import com.api.springboot.resources.exceptions.DataIntegratyViolationException;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExceptions(
				"Objeto não encontrado: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setID(null);
		return categoriaRepository.save(obj);

	}

	public Categoria update(Integer id, CategoriaDTO objDTO) {
		Categoria obj = findById(id);
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);

		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegratyViolationException e) {
			throw new com.api.springboot.resources.exceptions.DataIntegratyViolationException(
					"Categoria não pode ser DELETADA, possui livros associados.");
		}

	}
}
