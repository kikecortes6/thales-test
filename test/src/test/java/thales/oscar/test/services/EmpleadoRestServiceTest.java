package thales.oscar.test.services;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import thales.oscar.test.dtos.EmpleadoDto;
import thales.oscar.test.dtos.UsuarioServiceResponse;

public class EmpleadoRestServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private EmpleadoRestService instance;

	@BeforeEach
	void given() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test of obtenerTodosLosEmpleados method, of class EmpleadoRestService.
	 */
	@Test
	public void testObtenerTodosLosEmpleados() {
		System.out.println("obtenerTodosLosEmpleados");
		final List<EmpleadoDto> listaEmpleados = new ArrayList<>();
		final EmpleadoDto empleado = new EmpleadoDto();
		empleado.setId(Long.MAX_VALUE);
		listaEmpleados.add(empleado);
		final UsuarioServiceResponse<List<EmpleadoDto>> data = new UsuarioServiceResponse();
		data.setData(listaEmpleados);

		final ParameterizedTypeReference<UsuarioServiceResponse<List<EmpleadoDto>>> typeRef
			= new ParameterizedTypeReference<UsuarioServiceResponse<List<EmpleadoDto>>>() {
		};
		final ResponseEntity response = ResponseEntity.ok().body(data);

		when(restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET,
			new HttpEntity<>(null), typeRef))
			.thenReturn((ResponseEntity<UsuarioServiceResponse<List<EmpleadoDto>>>) response);

		final List<EmpleadoDto> result = instance.obtenerTodosLosEmpleados();
		assertEquals(1, result.size());

	}

	/**
	 * Test of obtenerEmpleadoPorId method, of class EmpleadoRestService.
	 */
	@Test
	public void testObtenerEmpleadoPorId() {
		System.out.println("obtenerEmpleadoPorId");
		final Long idEmpleado = 1L;
		final EmpleadoDto empleado = new EmpleadoDto();
		empleado.setId(idEmpleado);
		final UsuarioServiceResponse<EmpleadoDto> data = new UsuarioServiceResponse();
		data.setData(empleado);

		final ParameterizedTypeReference<UsuarioServiceResponse<EmpleadoDto>> typeRef
			= new ParameterizedTypeReference<UsuarioServiceResponse<EmpleadoDto>>() {
		};
		final ResponseEntity response = ResponseEntity.ok().body(data);

		when(restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employee/1", HttpMethod.GET,
			new HttpEntity<>(null), typeRef))
			.thenReturn((ResponseEntity<UsuarioServiceResponse<EmpleadoDto>>) response);

		final EmpleadoDto result = instance.obtenerEmpleadoPorId(idEmpleado);
		assertEquals(idEmpleado, result.getId());
	}

}
