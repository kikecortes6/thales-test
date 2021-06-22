import { EmpleadoInterface } from "../interfaces/empleado.interface";

export class EmpleadoModel implements EmpleadoInterface {
    id: number;
    employee_name: string;
    employee_salary: number;
    employee_age: number;
    profile_image: string;
    employee_anual_salary: number;
    constructor(id: number, employee_name: string, employee_salary: number,
        employee_age: number, profile_image: string, employee_anual_salary: number) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
        this.employee_anual_salary = employee_anual_salary;

    }


}
