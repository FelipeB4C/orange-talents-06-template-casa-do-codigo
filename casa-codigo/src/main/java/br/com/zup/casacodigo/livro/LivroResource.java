package br.com.zup.casacodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroResource {

	private LivroRepository repo;

	@PersistenceContext
	EntityManager manager;

	@Autowired
	public LivroResource(LivroRepository repo) {
		this.repo = repo;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> insert(@RequestBody @Valid LivroRequest obj) {
		Livro livro = obj.toModel(manager);
		repo.save(livro);
		return ResponseEntity.created(null).build();
	}

}
