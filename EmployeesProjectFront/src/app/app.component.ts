import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from './services/employees/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'EmployeesProjectFront';

  employeesForm :FormGroup;
  employees: any;

  constructor(public fb :FormBuilder,
              public employeeService: EmployeeService){
    
  }

  ngOnInit(): void {
    this.employeesForm = this.fb.group({
      id : ['',Validators.required],
      employee_name : ['',Validators.required],
	    employee_salary : ['',Validators.required],
	    employee_anual_salary : ['',Validators.required],
      employee_age : ['',Validators.required],
      profile_image : ['',Validators.required]
      }
    );

    this.employeeService.gatALLEmployees().subscribe(resp => {
      this.employees = resp;
      //console.log(resp);
    },
    error => (console.error(error))
    );

  }

  Listar(id:string):void{  
    console.log("XX ["+id+"]");
    if (id != null && id != "")  {
      this.employeeService.gatOneEmployee(id).subscribe(resp => {
        this.employees = resp;
        console.log(resp);
      },
      error => (console.error(error))
      );
    }else{
      this.employeeService.gatALLEmployees().subscribe(resp => {
        this.employees = resp;
        //console.log(resp);
      },
      error => (console.error(error))
      );      
    }
  }
}
