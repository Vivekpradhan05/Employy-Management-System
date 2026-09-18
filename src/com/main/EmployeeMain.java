package com.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.Controller.EmployeeController;
import com.entity.Employee;
import com.exception.SomethingWentWrong;

public class EmployeeMain {
		
		public static void main(String args[]) {
			EmployeeController emp = new EmployeeController();
			
			Scanner sc = new Scanner(System.in);
			
		
				System.out.println("1.Insert Employee");
				System.out.println("2.Update Employee");
				System.out.println("3.Delete Employee");
				System.out.println("4.Get by id");
				System.out.println("5.Get All Employee");
				System.out.println("6.Exit");
				
			int choice = sc.nextInt();
			switch(choice){
			case 1:	//Insert Employee
				try {
				Employee em = new Employee(3,"Diksha",30000,"Pune");
				String res = emp.insertEmployee(em);
				System.out.println(res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			break;
			
			case 2:  //Update Employee
				//update
				try {	
				Employee e = new Employee(1,"mona",30000,"PUNE");
				String result =emp.updateEmployee(e);
				System.out.println(result);
				}catch(SomethingWentWrong e) {
					System.out.println(e.getMessage());
				};
			break;
			
			case 3:  //Delete Employee
				try {
					System.out.println(emp.deleteEmployee(3));
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			break;
			
			case 4:  //Get EmployById
				try {
					Employee employ=emp.getEmployeeById(2);
					System.out.println(employ);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
			break;
			
			case 5:  //Get AllEmployee
				try {
					ArrayList<Employee> empr=emp.getAllEmploye();
					for(Employee e:empr) {
						System.out.println(e);
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			break;
			
			case 6: //Exit
				System.out.println("Exit");
			break;
			default:
				System.out.println("Invallid choice");
			
			}
			

			
			
			//Assignement 
			//1. User -  username , password , email , gender , dob , mobile no , address , age
			//insert , update , delete , getby id , get all
		
			//2.Book - id, name , price , author , qty
			//insert , update , delete , get , getall
			
			//3. Product - id , name , price , category  , qty
			//insert , update , delete , get , getAll
		}
}
