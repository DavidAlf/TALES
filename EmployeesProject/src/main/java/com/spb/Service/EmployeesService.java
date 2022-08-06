package com.spb.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.spb.Model.TblEmployee;

public interface EmployeesService {
	
	List<TblEmployee> AllEmployees() throws IOException;
	
	List<TblEmployee> OneEmployee	(BigDecimal id) throws IOException;
	
}
