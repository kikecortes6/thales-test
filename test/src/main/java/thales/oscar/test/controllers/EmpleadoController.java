package thales.oscar.test.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thales.oscar.test.dtos.EmpleadoDto;
import thales.oscar.test.exeptions.EmpleadoException;
import thales.oscar.test.services.EmpleadoBusinessService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoBusinessService empleadoBusinessService;

	@GetMapping()
	@RequestMapping("/todos")
	public ResponseEntity<List<EmpleadoDto>> obtenerTodosLosEmpleados() {

		ResponseEntity response = null;

		try {
			final List<EmpleadoDto> listaUsuarios = this.empleadoBusinessService.obtenerTodosLosEmpleados();
			response = ResponseEntity
				.ok()
				.body(listaUsuarios);
		} catch (final Exception exception) {
			response = ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(exception.getMessage());
		}

		return response;

	}

	@GetMapping()
	@RequestMapping("/{idEmpleado}")
	public ResponseEntity<EmpleadoDto> obeterEmpleadoPorId(final @PathVariable Long idEmpleado) {

		ResponseEntity response = null;

		try {
			final EmpleadoDto listaUsuarios = this.empleadoBusinessService.obtenerEmpleadoPorId(idEmpleado);

			response = ResponseEntity
				.ok()
				.body(listaUsuarios);
		} catch (final EmpleadoException exception) {
			response = ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(exception.getMessage());
		} catch (final Exception exception) {
			response = ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(exception.getMessage());
		}

		return response;

	}

}
