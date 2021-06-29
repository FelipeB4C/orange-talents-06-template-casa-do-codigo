package br.com.zup.casacodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.casacodigo.domain.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
	
}
