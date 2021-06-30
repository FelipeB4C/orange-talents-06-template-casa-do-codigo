package br.com.zup.casacodigo.autor;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoValidator implements Validator{

	private AutorRepository autorRepository;
	
	public ProibeEmailDuplicadoValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		AutorRequest request = (AutorRequest) target;
		Optional<Autor> autorEmail = autorRepository.findByEmail(request.getEmail());
		if(autorEmail.isPresent()) {
			errors.rejectValue("email", null, "Já existe esse e-mail cadastrado: "+request.getEmail());;
		}
	}

}
