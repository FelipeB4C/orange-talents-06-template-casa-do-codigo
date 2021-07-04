package br.com.zup.casacodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casacodigo.estado.Estado;
import br.com.zup.casacodigo.pais.Pais;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	private String documento;
	
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;

	@NotNull
	@ManyToOne
	private Pais pais;

	@ManyToOne
	private Estado estado;
	
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	
	public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
		String cidade, Pais pais, Estado estado, String telefone, String cep) {
	this.email = email;
	this.nome = nome;
	this.sobrenome = sobrenome;
	this.documento = documento;
	this.endereco = endereco;
	this.complemento = complemento;
	this.cidade = cidade;
	this.pais = pais;
	this.estado = estado;
	this.telefone = telefone;
	this.cep = cep;
}
	
	

}
