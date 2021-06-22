package thales.oscar.test.services;

import java.util.List;
import thales.oscar.test.dtos.EmpleadoDto;

public interface IEmpleadoRestService {

	List<EmpleadoDto> obtenerTodosLosEmpleados();

	EmpleadoDto obtenerEmpleadoPorId(final Long idEmpleado);

}
