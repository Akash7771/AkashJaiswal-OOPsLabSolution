package com.greatlearning.services;

import com.greatlearning.beans.Employee;

public interface EmployeeService {

    public void generatePassword(Employee employee);

    public void generateEmailAddress(Employee employee);

    public String showCredentials(Employee employee);

}
