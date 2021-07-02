package br.com.zup.casacodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorResource {
	
	private AutorRepository repo;
	private ProibeEmailDuplicadoValidator emailValidator;
	
	@Autowired
	public AutorResource(AutorRepository repo, ProibeEmailDuplicadoValidator emailValidator) {
		this.repo = repo;
		this.emailValidator = emailValidator;
	}
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailValidator);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> insert(@RequestBody @Valid AutorRequest objDto){
		Autor autor = objDto.toModel();
		autor = repo.save(autor);
		return ResponseEntity.created(null).build();
	}

}
