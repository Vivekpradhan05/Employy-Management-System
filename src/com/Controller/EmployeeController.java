package com.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Service.EmployeeService;
import com.entity.Employee;

public class EmployeeController {
		EmployeeService emp =new  EmployeeService();
		
		//insert imployee
		public String insertEmployee(Employee employ) {
			String result=emp.InsertEmployee(employ);
			return result;
		}
		
		//update employee
		public String updateEmployee(Employee employ) {
			String result = emp.UpdateEmployee(employ);
			return result;
		}
		
		//Delete employee
		public String deleteEmployee(int id) throws SQLException {	
			return emp.deleteEmployee(id);
		}
		
		//get employee
		public Employee getEmployeeById(int id) {
			return emp.getEmployeeBy(id);
		}
		
		public ArrayList<Employee> getAllEmploye() {
			return emp.getAllEmploy();
		}
}
