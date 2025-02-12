package br.com.zup.casacodigo.autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
	
	Optional<Autor> findByEmail(String email);
	
}
