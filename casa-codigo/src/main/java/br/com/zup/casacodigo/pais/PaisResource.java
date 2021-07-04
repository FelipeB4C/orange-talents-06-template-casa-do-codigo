package br.com.zup.casacodigo.pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisResource {

	private PaisRepository repo;
	
	@Autowired
	public PaisResource(PaisRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> insert(@RequestBody @Valid PaisRequest obj){
		Pais pais = obj.toModel();
		repo.save(pais);
		return ResponseEntity.created(null).build();
	}
	
}
