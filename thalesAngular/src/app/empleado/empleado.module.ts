import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmpleadoRoutingModule } from './empleado-routing.module';
import { ListaEmpleadoComponent } from './lista/lista-empleado.component';
import { UtilsModule } from '../utils/utils.module';
import { NgbAccordionModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ListaEmpleadoComponent
  ],
  imports: [
    CommonModule,
    EmpleadoRoutingModule,
    UtilsModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class EmpleadoModule { }
