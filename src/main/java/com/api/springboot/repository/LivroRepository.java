package com.api.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.springboot.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
