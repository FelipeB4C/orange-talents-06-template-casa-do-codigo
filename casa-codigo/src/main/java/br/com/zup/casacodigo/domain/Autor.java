package br.com.zup.casacodigo.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo nome não pode ser vazio")
	private String nome;
	
	@NotEmpty(message = "Campo e-mail não pode ser vazio")
	@Email
	private String email;
	
	@NotNull(message = "Campo instante não pode ser vazio")
	private String descricao;

	private LocalDateTime instante = LocalDateTime.now();

	public Autor() {
	}

	public Autor(Integer id, String nome, String email, String descricao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

}
