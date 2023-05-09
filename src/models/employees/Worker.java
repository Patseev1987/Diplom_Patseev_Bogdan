package models.employees;

import models.departments.Department;

public class Worker extends Employee{
    public Worker(String lastName, String firstName, String patronymic, Department department) {
        super(lastName, firstName, patronymic, department);

    }
}
