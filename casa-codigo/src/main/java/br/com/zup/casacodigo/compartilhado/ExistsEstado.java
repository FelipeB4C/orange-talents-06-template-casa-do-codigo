package br.com.zup.casacodigo.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ExistsEstadoValidator.class})
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsEstado {

	String message() default "Erro de validação, esse id não existe";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
//	String fieldName();
//	
//	Class<?> domainClass();

}
