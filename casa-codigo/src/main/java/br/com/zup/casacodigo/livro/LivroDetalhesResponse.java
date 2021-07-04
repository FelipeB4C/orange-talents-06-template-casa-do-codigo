package br.com.zup.casacodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.casacodigo.autor.Autor;
import br.com.zup.casacodigo.categoria.Categoria;

public class LivroDetalhesResponse {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int numeroPaginas;
	private String isbn;
	private String dataPublicacao;

	private Categoria categoria;

	private Autor autor;

	public LivroDetalhesResponse() {

	}

	public LivroDetalhesResponse(Livro livro) {
		titulo = livro.getTitulo();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		preco = livro.getPreco();
		numeroPaginas = livro.getNumeroPaginas();
		isbn = livro.getIsbn();
		dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		categoria = livro.getCategoria();
		autor = livro.getAutor();
	}

	public Livro verificaIdEBuscaLivro(LivroRepository repo, Integer id) {
		Optional<Livro> livro = repo.findById(id);
		return livro.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

}
