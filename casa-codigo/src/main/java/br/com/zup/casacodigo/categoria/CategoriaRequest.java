package br.com.zup.casacodigo.categoria;

import com.fasterxml.jackson.annotation.JsonCreator;

@CategoriaInsert
public class CategoriaRequest {

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
