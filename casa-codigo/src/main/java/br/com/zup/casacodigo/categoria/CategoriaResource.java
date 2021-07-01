package br.com.zup.casacodigo.categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	private CategoriaRepository repo;
	private ProibeCategoriaDuplicadaValidator categoriaValidator;
	
	public CategoriaResource(CategoriaRepository repo, ProibeCategoriaDuplicadaValidator categoriaValidator) {
		this.repo = repo;
		this.categoriaValidator = categoriaValidator;
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(categoriaValidator);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> insert(@RequestBody @Valid CategoriaRequest objDto){
		Categoria categoria = objDto.toModel(objDto);
		categoria = repo.save(categoria);
		return ResponseEntity.created(null).build();
	}
	
}
