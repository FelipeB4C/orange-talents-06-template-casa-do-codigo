package br.com.zup.casacodigo.livro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{
	
	Optional<Livro> findById(Integer id);
	
}
