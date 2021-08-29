package com.greatlearning.services;

import com.greatlearning.beans.Employee;
import java.util.Random;


public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void generatePassword(Employee employee) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnpopqrstuvwxyz1234567890";
        String SALTSPECIALCHARS ="@!#$^";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            if(salt.length() == 3){
                int index = (int) (rnd.nextFloat() * SALTSPECIALCHARS.length());
                salt.append(SALTSPECIALCHARS.charAt(index));
            }
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();

        employee.setPassword(saltStr);
    }

    @Override
    public void generateEmailAddress(Employee employee) {
        if(employee!=null && ( employee.getFirstName().equals("") || employee.getLastName().equals("") ) ){
            System.out.println("Invalid user details");
        }
        String departmentWise_emailPostFix = getemailPrefixByDepartmentName(employee.getDepartment());
        String emailId = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() + departmentWise_emailPostFix ;
        employee.setEmailId(emailId);
    }

    @Override
    public String showCredentials(Employee employee) {

       return
                "Email --> " + employee.getEmailId() + "\n" +
                        "Password --> " + employee.getPassword()

        ;

    }
    private String departmentEmailPrefix(String departmentName){
        if(departmentName.equals("Technical"))
            return "tech";
        if(departmentName.equals("Admin"))
            return "admin";
        if(departmentName.equals("Human Resource"))
            return "hr";
        if(departmentName.equals("Legal"))
            return "legal";
        return "";
    }
    private String getemailPrefixByDepartmentName(String departmentName){
        String str = departmentEmailPrefix(departmentName);
            if(!str.equals(""))
                str = "." + str;
        return  str + "@"+"greatlearning.com";
    }

}
