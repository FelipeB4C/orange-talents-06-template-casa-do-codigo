package br.com.zup.casacodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.casacodigo.autor.Autor;
import br.com.zup.casacodigo.categoria.Categoria;
import br.com.zup.casacodigo.compartilhado.ExistsId;
import br.com.zup.casacodigo.compartilhado.UniqueValue;

public class LivroRequest {

	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	@NotBlank
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	@Column(columnDefinition = "text")
	private String sumario;

	@NotNull
	@Min(value = 20)
	private BigDecimal preco;

	@NotNull
	@Min(value = 100)
	private int numeroPaginas;

	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	@NotBlank
	private String isbn;

	@Future
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataPublicacao;

	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	@NotNull
	private Integer categoriaId;

	
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	@NotNull
	private Integer autorId;

	public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn,
			Integer categoriaId, Integer autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Categoria categoria = manager.find(Categoria.class, categoriaId);
		@NotNull Autor autor = manager.find(Autor.class, autorId);
		
		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
				this.dataPublicacao, categoria, autor);
	}

	/*
	 * Setter criado pois estava dando erro ao inserir a data pelo construtor
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

}
