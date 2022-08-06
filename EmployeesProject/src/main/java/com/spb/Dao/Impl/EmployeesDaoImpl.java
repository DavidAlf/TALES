package com.spb.Dao.Impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.spb.Dao.EmployeesDAO;
import com.spb.Model.TblEmployee;
import com.spb.Util.CallService;

@Repository("EmployeesDAO")
@PropertySource("classpath:urls.properties")
public class EmployeesDaoImpl implements EmployeesDAO {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeesDaoImpl.class.getName());
	
	private CallService service;
	
	@Autowired
	private Environment env;

	@Override
	public List<TblEmployee> AllEmployees() throws IOException {
		logger.info("Start [AllEmployees]");
		
		String URL = env.getProperty("url.allEmployees");
		
		service = new CallService();
		
		String responseEmployees = service.callServices("AllEmployees", URL).body();
		
		List<TblEmployee> employeesList = new ArrayList<TblEmployee>();
		
		try {
			JSONObject jsonAll = new JSONObject(responseEmployees);									
			
			JSONArray jsonEmployees = jsonAll.getJSONArray("data");				

			for (int i = 0; i < jsonEmployees.length(); i++) {				
			    JSONObject dato = jsonEmployees.getJSONObject(i);
			    
			    TblEmployee employee = new TblEmployee();
			    employee = envioDatos(dato);			   
			    
			    employeesList.add(employee);
			}												
			
		}catch (Exception e) {
			logger.error("Error [AllEmployees] "+e.getMessage());
		}

		
		logger.info("End [AllEmployees]");
		return employeesList;
	}

	@Override
	public List<TblEmployee>  OneEmployee(BigDecimal id) throws IOException {
		logger.info("Start [OneEmployee]");
		
		String URL = env.getProperty("url.oneEmployees");
		
		service = new CallService();
		String responseEmployee = service.callServices("OneEmployee", URL+id).body();
		TblEmployee employee = new TblEmployee();
		List<TblEmployee> employeesList = new ArrayList<TblEmployee>();
		try {
			JSONObject jsonAll = new JSONObject(responseEmployee);									
			
			JSONObject jsonEmployee = jsonAll.getJSONObject("data");
						
			employee = envioDatos(jsonEmployee);
		
		}catch (Exception e) {
			logger.error("Error [OneEmployee] "+e.getMessage());
		}			
		employeesList.add(employee);
		logger.info("End [OneEmployee]");
		return employeesList;
	}
	
	private TblEmployee envioDatos(JSONObject jsonEmployee) {
		
		TblEmployee employee = new TblEmployee();	
		
		try {
			employee.setId(new BigDecimal(jsonEmployee.get("id").toString()));
			employee.setEmployee_name(jsonEmployee.get("employee_name").toString());
			employee.setEmployee_salary(new BigDecimal(jsonEmployee.get("employee_salary").toString()));
		    BigDecimal anual = new BigDecimal((new BigDecimal(jsonEmployee.get("employee_salary").toString())).intValue()*12);
		    employee.setEmployee_anual_salary(anual);
		    employee.setEmployee_age(new BigDecimal(jsonEmployee.get("employee_age").toString()));
		    
//		    System.out.println("xx "+employee.getEmployee_salary()+" - "+employee.getEmployee_anual_salary());
		}catch (Exception e) {
			logger.error("Error [envioDatos] "+e.getMessage());
		}
		
		return employee;
	}

}
