package models.employees;

import models.departments.Department;

import java.time.LocalDate;

public class Worker extends Employee{
    public Worker(String lastName, String firstName, String patronymic, Department department, LocalDate joinDate, EmployeeEnum occupation) {
        super(lastName, firstName, patronymic, department, joinDate, occupation);
    }
}
