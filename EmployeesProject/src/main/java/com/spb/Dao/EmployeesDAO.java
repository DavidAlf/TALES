package com.spb.Dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.spb.Model.TblEmployee;

public interface EmployeesDAO {
	
	List<TblEmployee> AllEmployees() throws IOException;
	
	List<TblEmployee> OneEmployee(BigDecimal id) throws IOException;
	
}
