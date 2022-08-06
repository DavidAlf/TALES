package com.spb.Service.Impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spb.Dao.EmployeesDAO;
import com.spb.Model.TblEmployee;
import com.spb.Service.EmployeesService;


@Service("EmployeesService")
public class EmployeesServiceImpl implements EmployeesService{

	@Autowired
	private EmployeesDAO employeesDAO;

	@Override
	public List<TblEmployee> AllEmployees() throws IOException {
		return this.employeesDAO.AllEmployees();
	}

	@Override
	public List<TblEmployee> OneEmployee(BigDecimal id)  throws IOException {
		return this.employeesDAO.OneEmployee(id);
	}

		
}
