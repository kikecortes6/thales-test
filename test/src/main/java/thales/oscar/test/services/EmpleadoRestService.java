package thales.oscar.test.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import thales.oscar.test.dtos.EmpleadoDto;
import thales.oscar.test.dtos.UsuarioServiceResponse;

@Service
public class EmpleadoRestService implements IEmpleadoRestService {

	final static private String URL_BASE = "https://dummy.restapiexample.com/api/v1/";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<EmpleadoDto> obtenerTodosLosEmpleados() {
		final String uri = URL_BASE + "employees";

		final ParameterizedTypeReference<UsuarioServiceResponse<List<EmpleadoDto>>> typeRef
			= new ParameterizedTypeReference<UsuarioServiceResponse<List<EmpleadoDto>>>() {
		};
		final ResponseEntity<UsuarioServiceResponse<List<EmpleadoDto>>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(
			null),
			typeRef);
		final UsuarioServiceResponse<List<EmpleadoDto>> result = responseEntity.getBody();

		return result.getData();
	}

	public EmpleadoDto obtenerEmpleadoPorId(final Long idEmpleado) {

		final String uri = URL_BASE + "employee/" + idEmpleado;

		final ParameterizedTypeReference<UsuarioServiceResponse<EmpleadoDto>> typeRef
			= new ParameterizedTypeReference<UsuarioServiceResponse<EmpleadoDto>>() {
		};
		final ResponseEntity<UsuarioServiceResponse<EmpleadoDto>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(null),
			typeRef);
		final UsuarioServiceResponse<EmpleadoDto> result = responseEntity.getBody();

		return result.getData();

	}

}
