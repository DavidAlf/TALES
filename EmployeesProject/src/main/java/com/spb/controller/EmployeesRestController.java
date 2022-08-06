package com.spb.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spb.Model.TblEmployee;
import com.spb.Service.EmployeesService;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeesRestController {
	
	private static Logger logger = LoggerFactory.getLogger(EmployeesRestController.class.getName());
	
	@Autowired
	private EmployeesService employeesService; 	
	

	@RequestMapping(value="/all", method = RequestMethod.GET, produces = "application/json")
	public List<TblEmployee> AllEmployees() throws IOException{
		
		try {
			List<TblEmployee> employees = new ArrayList<TblEmployee>();
			employees = this.employeesService.AllEmployees();
			
			return employees;
		} catch (Exception e) {
			
			logger.warn("Error en AllEmployees - " + e.toString());
			return null;
		}				
	}
	
	@RequestMapping(value="/one", method = RequestMethod.GET, produces = "application/json")
	public List<TblEmployee> OneEmployee(@RequestParam(required = false, defaultValue = "") BigDecimal id) throws IOException{
		
		try {
			List<TblEmployee> employees = new ArrayList<TblEmployee>();			
			employees = this.employeesService.OneEmployee(id);
			
			return employees;
		} catch (Exception e) {
			
			logger.warn("Error en OneEmployee - " + e.toString());
			return null;
		}				
	}
}
