package com.api.springboot.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.api.springboot.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Campo NOME não pode ser vazio.")
	@Length(min = 3, max = 20, message = "O campo NOME deve conter entre 3 e 20 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Campo DESCRIÇÃO não pode sr vazio.")
	@Length(min = 10, max = 100, message = "O campo DESCRICAO deve conter entre 10 e 100 caracteres.")
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super() ;
		this.id = obj.getID();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
