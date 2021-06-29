package br.com.zup.casacodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	@NotBlank(message = "Campo nome não pode ser vazio")
	private String nome;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Campo e-mail não pode ser vazio")
	@Email
	private String email;
	
	@Column(nullable = false)
	@NotNull(message = "Campo instante não pode ser vazio")
	private String descricao;

	@Column(nullable = false)
	@NotBlank
	private LocalDateTime instante = LocalDateTime.now();

	public Autor() {
	}

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

}
