package br.com.zup.casacodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorResource {
	
	@Autowired
	private AutorRepository repo;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> insert(@RequestBody @Valid AutorDTO objDto){
		Autor autor = objDto.toModel(objDto);
		autor = repo.save(autor);
		return ResponseEntity.created(null).build();
	}

}
