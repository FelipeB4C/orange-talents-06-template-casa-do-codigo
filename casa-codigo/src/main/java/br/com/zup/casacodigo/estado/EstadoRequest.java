package br.com.zup.casacodigo.estado;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.casacodigo.compartilhado.ExistsId;
import br.com.zup.casacodigo.compartilhado.UniqueEstadoPorPais;
import br.com.zup.casacodigo.pais.Pais;
import br.com.zup.casacodigo.pais.PaisRepository;

@UniqueEstadoPorPais
public class EstadoRequest {

	@NotBlank
	public String nome;

	@ExistsId(domainClass = Pais.class, fieldName = "id")
	@NotNull
	public Integer paisId;

	public EstadoRequest(String nome, Integer paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public Estado toModel(PaisRepository paisRepo) {
		@NotNull
		Pais pais = findPais(paisRepo);
		return new Estado(this.nome, pais);
	}

	public Pais findPais(PaisRepository paisRepo) {
		@NotNull
		Optional<Pais> pais = paisRepo.findById(paisId);
		return pais.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public String getNome() {
		return nome;
	}

	public Integer getPaisId() {
		return paisId;
	}

}
