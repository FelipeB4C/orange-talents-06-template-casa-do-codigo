package br.com.zup.casacodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zup.casacodigo.estado.EstadoRequest;

public class UniqueEstadoPorPaisValidator implements ConstraintValidator<UniqueEstadoPorPais, EstadoRequest> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(UniqueEstadoPorPais params) {
	}

	@Override
	public boolean isValid(EstadoRequest obj, ConstraintValidatorContext context) {

		Query query = manager.createQuery("select 1 from Estado where nome =:nomeEstado AND pais_id =:paisId ");
		query.setParameter("nomeEstado", obj.getNome());
		query.setParameter("paisId", obj.getPaisId());

		List<?> list = query.getResultList();

		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate("Já existe um Estado com esse nome no país indicado").addPropertyNode("nome")
				.addConstraintViolation();
		
		
		return list.isEmpty();
	}

}
