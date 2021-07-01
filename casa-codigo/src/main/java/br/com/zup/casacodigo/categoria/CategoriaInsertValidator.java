package br.com.zup.casacodigo.categoria;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zup.casacodigo.compartilhado.ErroFormularioResponse;

public class CategoriaInsertValidator implements ConstraintValidator<CategoriaInsert, CategoriaRequest> {

	private CategoriaRepository repo;

	public CategoriaInsertValidator(CategoriaRepository repo) {
		this.repo = repo;
	}

	@Override
	public void initialize(CategoriaInsert params) {
	}

	@Override
	public boolean isValid(CategoriaRequest obj, ConstraintValidatorContext context) {

		List<ErroFormularioResponse> list = new ArrayList<>();

		Categoria nome = repo.findByNome(obj.getNome());

		if (nome != null) {
			list.add(new ErroFormularioResponse("nome", "Já existe categoria com esse nome"));

		}

		for (ErroFormularioResponse e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getErro()).addPropertyNode(e.getCampo())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}

}
