package br.com.zup.casacodigo.estado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casacodigo.pais.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	private PaisRepository paisRepo;
	private EstadoRepository repo;
	
	@Autowired
	public EstadoResource(EstadoRepository repo, PaisRepository paisRepo) {
		this.repo = repo;
		this.paisRepo = paisRepo;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> insert(@RequestBody @Valid EstadoRequest obj){
		Estado estado = obj.toModel(paisRepo);
		repo.save(estado);
		return ResponseEntity.created(null).build();
	}

}
