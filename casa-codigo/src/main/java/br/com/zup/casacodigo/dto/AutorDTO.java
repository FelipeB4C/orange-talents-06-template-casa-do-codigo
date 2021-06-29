package br.com.zup.casacodigo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.casacodigo.domain.Autor;

public class AutorDTO {

	private Integer id;

	@NotEmpty(message = "Campo nome não pode ser vazio")
	private String nome;

	@NotEmpty(message = "Campo e-mail não pode ser vazio")
	@Email
	private String email;

	@NotEmpty(message = "Campo descrição não pode ser vazio")
	@Size(max = 400)
	private String descricao;

	@NotNull(message = "Campo instante não pode ser vazio")
	private LocalDateTime instante = LocalDateTime.now();

	public AutorDTO(Integer id, String nome, String email, String descricao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor converterDTO(AutorDTO obj) {
		return new Autor(this.id, this.nome, this.email, this.descricao);
	}
	
}
