import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private API_SERVER_ALL = "http://localhost:9100/employees/all";
  private API_SERVER_ONE = "http://localhost:9100/employees/one?id=";

  constructor(private httpClient:HttpClient) { }

  public gatALLEmployees(): Observable<any>{
    return this.httpClient.get(this.API_SERVER_ALL);
  }

  public gatOneEmployee(id:any): Observable<any>{
    return this.httpClient.get(this.API_SERVER_ONE+id);
  }
}
