package br.com.zup.casacodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.casacodigo.autor.Autor;
import br.com.zup.casacodigo.categoria.Categoria;

public class LivroDetalhesResponse {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;

	private Categoria categoria;

	private Autor autor;

	public LivroDetalhesResponse(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas,
			String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	public LivroDetalhesResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.categoria = livro.getCategoria();
		this.autor = livro.getAutor();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

}
