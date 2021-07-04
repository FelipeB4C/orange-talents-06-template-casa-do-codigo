package br.com.zup.casacodigo.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.casacodigo.compartilhado.UniqueValue;

public class PaisRequest {

	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	@NotBlank
	public String nome;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public PaisRequest(String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
	
}
