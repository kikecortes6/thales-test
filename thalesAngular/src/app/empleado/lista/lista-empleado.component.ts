import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { EmpleadoModel } from 'src/app/models/empleado.model';
import { EmpleadoService } from '../empleado.service';

@Component({
  selector: 'app-empleado',
  templateUrl: './lista-empleado.component.html',
  styleUrls: ['./lista-empleado.component.scss']
})
export class ListaEmpleadoComponent implements OnInit {

  empleados: EmpleadoModel[] = [];
  loading = false;
  busquedaEmpleadoForm: FormGroup;

  constructor(private empleadoService: EmpleadoService,
    private toastrService: ToastrService,
    private formBuilder: FormBuilder) {
    this.busquedaEmpleadoForm = this.formBuilder.group({
      id: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
  }

  buscarEmpleado(): void {
    this.loading = true;
    this.empleados = [];
    const idEmpleado = this.busquedaEmpleadoForm.controls.id.value;
    const idEmp = Number(idEmpleado)
    if (idEmpleado === null || idEmpleado === "") {
      this.empleadoService.obtenerTodosLosEmpleados()
        .subscribe(empleados => {
          this.empleados = empleados;
          this.loading = false;
        });
    } else if (isNaN(idEmp)) {
      this.toastrService.error('No se ha ingresado un valor númerico', 'Error');
      this.loading = false;
    } else if (idEmp < 0) {
      this.toastrService.error('El id debe ser un valor númerico positivo', 'Error');
      this.loading = false;
    } else {
      this.empleadoService.obetenerEmpeladoPorId(idEmp)
        .subscribe(empleado => {
          this.empleados.push(empleado);
          this.loading = false;
        });
    }

  }



}
