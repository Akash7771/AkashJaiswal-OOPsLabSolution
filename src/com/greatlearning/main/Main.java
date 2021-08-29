package com.greatlearning.main;

import com.greatlearning.beans.Employee;
import com.greatlearning.services.EmployeeService;
import com.greatlearning.services.EmployeeServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Employees First Name : ");
        String firstName = sc.nextLine();

        System.out.println("Enter the Employees Last Name : ");
        String lastName = sc.nextLine();

        System.out.println("Please enter the department from the following \n"+
                "1. Technical \n"+
                        "2. Admin \n"+
                        "3. Human Resource \n"+
                        "4. Legal \n"
                );
        Integer departmentId = sc.nextInt();

        Employee employee = new Employee(firstName.trim(),  lastName.trim());

        switch (departmentId){
            case 1 :
                employee.setDepartment("Technical");
                break;
            case 2 : employee.setDepartment("Admin"); break;
            case 3 : employee.setDepartment("Human Resource"); break;
            case 4 : employee.setDepartment("Legal"); break;
            default: employee.setDepartment("");
        }

        employeeService.generateEmailAddress(employee);
        employeeService.generatePassword(employee);
        System.out.println( "Dear " + employee.getFirstName() +" your generated credentials are as follows\n" + employeeService.showCredentials(employee) );

    }
}
