package thales.oscar.test.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thales.oscar.test.dtos.EmpleadoDto;
import thales.oscar.test.exeptions.EmpleadoException;

@Service
public class EmpleadoBusinessService {

	@Autowired
	private IEmpleadoRestService usuarioRestService;

	public List<EmpleadoDto> obtenerTodosLosEmpleados() {
		final List<EmpleadoDto> listaEmpleados = this.usuarioRestService.obtenerTodosLosEmpleados();
		listaEmpleados.forEach(empleado -> empleado.setEmployeeAnualSalary(empleado.getEmployeeSalary() * 12));
		return listaEmpleados;
	}

	public EmpleadoDto obtenerEmpleadoPorId(final Long idEmpleado) throws EmpleadoException {

		if (idEmpleado < 0) {
			throw new EmpleadoException("Id empleado no puede ser negativo");
		}

		final EmpleadoDto empleado = this.usuarioRestService.obtenerEmpleadoPorId(idEmpleado);

		empleado.setEmployeeAnualSalary(empleado.getEmployeeSalary() * 12);

		return empleado;
	}

}
