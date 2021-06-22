package thales.oscar.test.services;

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
import thales.oscar.test.dtos.EmpleadoDto;

public class EmpleadoBusinessServiceTest {

	@Mock
	private IEmpleadoRestService usuarioRestService;

	@InjectMocks
	private EmpleadoBusinessService instance;

	@BeforeEach
	void given() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test of obtenerTodosLosEmpleados method, of class EmpleadoBusinessService.
	 */
	@Test
	public void testObtenerTodosLosEmpleados() {
		System.out.println("obtenerTodosLosEmpleados");
		final List<EmpleadoDto> listaEmpleados = new ArrayList<>();
		final EmpleadoDto empleado = new EmpleadoDto();
		empleado.setId(Long.MAX_VALUE);
		empleado.setEmployeeSalary(1200L);
		listaEmpleados.add(empleado);

		when(this.usuarioRestService.obtenerTodosLosEmpleados())
			.thenReturn(listaEmpleados);

		final List<EmpleadoDto> result = instance.obtenerTodosLosEmpleados();
		assertEquals(empleado.getEmployeeSalary() * 12, result.get(0).getEmployeeAnualSalary());
	}

	/**
	 * Test of obtenerEmpleadoPorId method, of class EmpleadoBusinessService.
	 */
	@Test
	public void testObtenerEmpleadoPorId() throws Exception {
		System.out.println("obtenerEmpleadoPorId");
		final Long idEmpleado = 1L;
		final EmpleadoDto empleado = new EmpleadoDto();
		empleado.setId(idEmpleado);
		empleado.setEmployeeSalary(1200L);
		when(this.usuarioRestService.obtenerEmpleadoPorId(ArgumentMatchers.anyLong()))
			.thenReturn(empleado);

		final EmpleadoDto result = instance.obtenerEmpleadoPorId(idEmpleado);
		assertEquals(empleado.getEmployeeSalary() * 12, result.getEmployeeAnualSalary());
	}

}
