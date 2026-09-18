package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Employee;
import com.exception.EmployeeNullException;
import com.jdbcConnection.JDBCUtil;

public class EmployeeDao {
	//database Code
	
	Connection con = JDBCUtil.createConnection();
	
	public void createTable() {
		try {
		Statement st = con.createStatement();
		st.execute("CREATE TABLE EMPLOY(ID NUMBER(10),NAME VARCHAR(10),SALARY NUMBER(10),CITY VARCHAR(10))");
		System.out.println("Table created");
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Employee Insert in DB Code 
//	public String insertEmployee(ArrayList<Employee> emp) {
//		try {
//			Statement st =con.createStatement();
//			
//			for(Employee e:emp) {
//				st.execute("INSERT INTO EMPLOY (ID, NAME, SALARY, CITY) VALUES (" +
//				           e.getId() + ", '" +
//				           e.getName() + "', " +
//				           e.getSalary() + ", '" +
//				           e.getCity() + "')");
//			}
//			
//			
//
//			System.out.println("inserted");
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return "Employee Inserted Successfully";
//	}
	
	
	//Recommonded 
	public String insertEmployee(Employee employee) {
		try {
			//Statement st =con.createStatement();
			if(employee == null) {
				throw new EmployeeNullException("Employee is null please insert values");
			}
			PreparedStatement ps = con.prepareStatement(
				    "INSERT INTO EMPLOY (ID, NAME, SALARY, CITY) VALUES (?, ?, ?, ?)"
				);
				ps.setInt(1, employee.getId());
				ps.setString(2, employee.getName());
				ps.setDouble(3, employee.getSalary());
				ps.setString(4, employee.getCity());
				ps.executeUpdate();
				System.out.println("inserted");

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Employee Inserted Successfully";
	}
	
	//Update 
	public String updateEmployee(Employee employee) {
		try {
		PreparedStatement pst =con.prepareStatement("UPDATE EMPLOY SET NAME=?, SALARY=?, CITY=? WHERE ID=?");
		pst.setString(1, employee.getName());
		pst.setDouble(2, employee.getSalary());
		pst.setString(3, employee.getCity());
		pst.setInt(4, employee.getId());
		int value = pst.executeUpdate();
		if(value>0) {
			return "Employee updated";
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	//delete
	public String delete(int id) {
		try {
		PreparedStatement pst =con.prepareStatement("DELETE FROM EMPLOY WHERE ID=?");
		pst.setInt(1, id);
		int value =pst.executeUpdate();
		if(value>0) {
			return "Employee deleted";
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	//Get single employeeById
	public Employee getEmployeeById(int id) {
		Employee employ = null;
		try {
		PreparedStatement pst =con.prepareStatement("SELECT * FROM EMPLOY WHERE ID=?");
		pst.setInt(1, id);
		ResultSet rs =pst.executeQuery();
		
		while(rs.next()) {
			int id1=rs.getInt("ID");
			String name=rs.getString("NAME");
			double salary=rs.getDouble("SALARY");
			String city=rs.getString("CITY");
			employ = new Employee(id1,name,salary,city);
				}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employ;
		
	}
	
	//Get all employies
	public ArrayList<Employee> getAllEmploy() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		Employee employ = null;
		try {
		PreparedStatement pst =con.prepareStatement("SELECT * FROM EMPLOY");
		ResultSet rs =pst.executeQuery();
		
		while(rs.next()) {
			int id1=rs.getInt("ID");
			String name=rs.getString("NAME");
			double salary=rs.getDouble("SALARY");
			String city=rs.getString("CITY");
			
			employ = new Employee(id1,name,salary,city);
			employees.add(employ); 
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employees;
		
	}
	
}
