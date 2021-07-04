package br.com.zup.casacodigo.cliente;

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
@RequestMapping("/clientes")
public class ClienteResource {

	@PersistenceContext
	private EntityManager manager;

	private ClienteRepository repo;

	@Autowired
	public ClienteResource(ClienteRepository repo) {
		this.repo = repo;
	}

	@PostMapping
	@Transactional
	public ResponseEntity<Void> insert(@RequestBody @Valid ClienteRequest obj) {
		Cliente cliente = obj.toModel(manager);
		repo.save(cliente);
		return ResponseEntity.created(null).build();
	}

}
