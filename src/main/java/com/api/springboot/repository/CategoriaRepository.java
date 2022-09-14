package com.api.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.springboot.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
