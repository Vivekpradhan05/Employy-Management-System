package com.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.exception.AllEmployNotFound;
import com.exception.EmployyNotFound;
import com.exception.SomethingWentWrong;

public class EmployeeService {

	EmployeeDao dao = new EmployeeDao();
	
	
	//Insert employee
	public String InsertEmployee(Employee employe) {
		String result = dao.insertEmployee(employe);
		return result;
	}
	
	//Update Employee
	public String UpdateEmployee(Employee employe) {
		String result = dao.updateEmployee(employe);
		if(result == null) {
			throw new SomethingWentWrong("Check your sql query again");
		}
		return result;
	}
	
	//Delete Employee
	public String deleteEmployee(int id) throws SQLException
	{
		String result = dao.delete(id);
		if(result == null) {
			throw new SQLException("id not exist");
		}
		return result;
	}
	
	//get Employee by id
	public Employee getEmployeeBy(int id) {
		Employee employ= dao.getEmployeeById(id);
		if(employ == null) {
			throw new EmployyNotFound("Employee not found");
		}
		return employ;
	}
	
	//Get all employee
	public ArrayList<Employee> getAllEmploy() {
		ArrayList<Employee> employ = dao.getAllEmploy();
		if(employ.isEmpty()) {
			throw new AllEmployNotFound("No employ present in db");
		}
		return employ;
	}
	
}
