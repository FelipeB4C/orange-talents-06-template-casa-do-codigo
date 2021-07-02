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

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	@NotBlank
	private String nome;
	
	@Column(nullable = false)
	@NotBlank
	@Email(message = "Informe um endereço de e-mail válido")
	private String email;
	
	@Column(nullable = false)
	@NotNull
	private String descricao;

	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime instante = LocalDateTime.now();

	@Deprecated
	public Autor() {
	}

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}
	
}
