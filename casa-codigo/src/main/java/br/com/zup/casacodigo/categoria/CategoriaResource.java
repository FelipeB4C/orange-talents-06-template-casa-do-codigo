package br.com.zup.casacodigo.categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	private CategoriaRepository repo;

	@Autowired
	public CategoriaResource(CategoriaRepository repo) {
		this.repo = repo;

	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> insert(@RequestBody @Valid CategoriaRequest objDto) {
		Categoria categoria = objDto.toModel();
		categoria = repo.save(categoria);
		return ResponseEntity.created(null).build();
	}

}
