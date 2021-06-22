package thales.oscar.test.controllers;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import thales.oscar.test.dtos.EmpleadoDto;
import thales.oscar.test.exeptions.EmpleadoException;
import thales.oscar.test.services.EmpleadoBusinessService;

/**
 *
 * @author oscarenriquecortesmedina
 */
public class EmpleadoControllerTest {

	@Mock
	private EmpleadoBusinessService empleadoBusinessService;

	@InjectMocks
	private EmpleadoController instance;

	@BeforeEach
	void given() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test of obtenerTodosLosEmpleados method, of class EmpleadoController.
	 */
	@Test
	public void testObtenerTodosLosEmpleados() {
		System.out.println("obtenerTodosLosEmpleados");

		final List<EmpleadoDto> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(new EmpleadoDto());

		when(this.empleadoBusinessService.obtenerTodosLosEmpleados())
			.thenReturn(listaEmpleados);
		final ResponseEntity<List<EmpleadoDto>> result = instance.obtenerTodosLosEmpleados();
		assertEquals(1, result.getBody().size());
	}

	/**
	 * Test of obeterEmpleadoPorId method, of class EmpleadoController.
	 */
	@Test
	public void testObeterEmpleadoPorId() throws EmpleadoException {
		System.out.println("obeterEmpleadoPorId");

		final Long idEmpleado = 1L;

		final EmpleadoDto empleado = new EmpleadoDto();
		empleado.setId(idEmpleado);

		when(this.empleadoBusinessService.obtenerEmpleadoPorId(ArgumentMatchers.anyLong()))
			.thenReturn(empleado);

		final ResponseEntity<EmpleadoDto> result = instance.obeterEmpleadoPorId(idEmpleado);
		assertEquals(idEmpleado, result.getBody().getId());
		// TODO review the generated test code and remove the default call to fail.
	}

}
