package br.com.zup.casacodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casacodigo.compartilhado.CpfOuCnpj;
import br.com.zup.casacodigo.compartilhado.ExistsEstado;
import br.com.zup.casacodigo.compartilhado.UniqueValue;
import br.com.zup.casacodigo.estado.Estado;
import br.com.zup.casacodigo.pais.Pais;

@ExistsEstado
public class ClienteRequest {

	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@CpfOuCnpj
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;

	@NotNull
	private Integer paisId;

	private Integer estadoId;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	public ClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Integer paisId, Integer estadoId, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, paisId);
		Estado estado = manager.find(Estado.class, estadoId);
		return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
				this.cidade, pais, estado, this.telefone, this.cep);
	}

	public Integer getPaisId() {
		return paisId;
	}
	
	public Integer getEstadoId() {
		return estadoId;
	}
}
