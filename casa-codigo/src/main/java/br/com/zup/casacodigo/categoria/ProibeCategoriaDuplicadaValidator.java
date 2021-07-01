package br.com.zup.casacodigo.categoria;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator{

	private CategoriaRepository categoriaRepository;
	
	public ProibeCategoriaDuplicadaValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		CategoriaRequest request = (CategoriaRequest) target;
		Optional<Categoria> categoriaNome = categoriaRepository.findByNome(request.getNome());
		if(categoriaNome.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com esse nome: "+request.getNome());;
		}
	}

}
