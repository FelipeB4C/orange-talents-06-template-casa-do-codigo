package br.com.zup.casacodigo.autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

	@NotBlank
	private String nome;

	@NotBlank
	@Email(message = "Informe um endereço de e-mail válido")
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	private LocalDateTime instante = LocalDateTime.now();

	public AutorRequest(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		return email;
	}
	
	
}
