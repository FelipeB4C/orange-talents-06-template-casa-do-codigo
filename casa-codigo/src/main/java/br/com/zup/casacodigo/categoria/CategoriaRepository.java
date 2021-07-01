package br.com.zup.casacodigo.categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	Optional<Categoria> findByNome(String nome);
	
}
