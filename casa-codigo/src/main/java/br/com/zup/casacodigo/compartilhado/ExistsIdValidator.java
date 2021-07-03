package br.com.zup.casacodigo.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {

	private Class<?> klass;
	private String domainAttribute;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(ExistsId params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println("Tô chegando aqui?");
		Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		System.out.println("E aqui?");

		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate("Não existe um registro em "+klass.getSimpleName()+" com essa informação: "+value)
				.addConstraintViolation();
		
		System.out.println(list);
		return !list.isEmpty();
	}

}
