package br.com.zup.casacodigo.compartilhado;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.casacodigo.cliente.ClienteRequest;
import br.com.zup.casacodigo.estado.Estado;
import br.com.zup.casacodigo.estado.EstadoRepository;

public class ExistsEstadoValidator implements ConstraintValidator<ExistsEstado, ClienteRequest> {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private EstadoRepository repo;

	@Override
	public void initialize(ExistsEstado params) {
	}

	@Override
	public boolean isValid(ClienteRequest obj, ConstraintValidatorContext context) {

		List<ErroFormularioResponse> list = new ArrayList<>();

		Estado estado = repo.findByPaisId(obj.getPaisId());
		if (estado != null) {
			if (obj.getEstadoId() == null) {
				list.add(new ErroFormularioResponse("estadoId", "Erro, insira um estado"));
			}

		}

		for (ErroFormularioResponse e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getErro()).addPropertyNode(e.getCampo())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
