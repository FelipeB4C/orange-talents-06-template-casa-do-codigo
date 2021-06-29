package br.com.zup.casacodigo.autor;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorDTO {

	@NotBlank(message = "Campo nome não pode ser vazio")
	private String nome;

	@NotBlank(message = "Campo e-mail não pode ser vazio")
	@Email
	private String email;

	@NotBlank(message = "Campo descrição não pode ser vazio")
	@Size(max = 400)
	private String descricao;

	@NotNull(message = "Campo instante não pode ser vazio")
	private LocalDateTime instante = LocalDateTime.now();

	public AutorDTO(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel(AutorDTO obj) {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
}
