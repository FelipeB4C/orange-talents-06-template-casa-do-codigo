package br.com.zup.casacodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaRequest {

	@NotBlank
	private String nome;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public CategoriaRequest(String nome) {
		this.nome = nome;
	}

	public Categoria toModel(CategoriaRequest objDto) {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return nome;
	}

}
