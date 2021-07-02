package br.com.zup.casacodigo.livro;

public class LivroResponse {

	private Integer id;
	private String titulo;


	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}
	
	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
