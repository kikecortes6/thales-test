import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmpleadoModel } from '../models/empleado.model';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  constructor(private http: HttpClient) {
  }

  obtenerTodosLosEmpleados(): Observable<EmpleadoModel[]> {
    return this.http.get<EmpleadoModel[]>('empleado/todos');
  }

  obetenerEmpeladoPorId(idEmpleado: number): Observable<EmpleadoModel> {
    return this.http.get<EmpleadoModel>(`empleado/${idEmpleado}`);
  }

}
