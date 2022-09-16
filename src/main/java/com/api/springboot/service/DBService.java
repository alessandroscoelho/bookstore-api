package com.api.springboot.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.springboot.domain.Categoria;
import com.api.springboot.domain.Livro;
import com.api.springboot.repository.CategoriaRepository;
import com.api.springboot.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Desenho", "Livros Infantís");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren ipsum", cat1);
		Livro l2 = new Livro(null, "O mundo de Bob", "Autor desconhecido", "Loren ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		cat2.getLivros().addAll(Arrays.asList(l2));

		categoriaRepository.saveAll(Arrays.asList(cat1));
		livroRepository.saveAll(Arrays.asList(l1));
		
		categoriaRepository.saveAll(Arrays.asList(cat2));
		livroRepository.saveAll(Arrays.asList(l2));

	}

}
