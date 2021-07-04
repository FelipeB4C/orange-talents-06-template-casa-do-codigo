package br.com.zup.casacodigo.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import br.com.zup.casacodigo.pais.Pais;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String nome;

	@ManyToOne
	private Pais pais;

	@Deprecated
	public Estado() {

	}

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

}
