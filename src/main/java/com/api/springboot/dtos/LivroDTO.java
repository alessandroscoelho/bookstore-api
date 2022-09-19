package com.api.springboot.dtos;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.api.springboot.domain.Livro;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "O campo TITULO não deve ser vazio.")
	@Length(min = 1, max = 100, message = "O campo TITULO deve conter entre 10 e 100 catacteres.")
	private String titulo;

	@NotEmpty(message = "O campo NOME DO AUTOR não deve ser vazio.")
	@Length(min = 1, max = 100, message = "O campo NOME DO AUTOR deve conter entre 10 e 100 catacteres.")
	private String nome_autor;

	@NotEmpty(message = "O campo TEXTO não deve ser vazio.")
	@Length(min = 1, max = 100, message = "O campo TEXTO deve conter entre 10 e 100 catacteres.")
	private String texto;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getNome_autor();
		this.nome_autor = obj.getNome_autor();
		this.texto = obj.getTexto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
