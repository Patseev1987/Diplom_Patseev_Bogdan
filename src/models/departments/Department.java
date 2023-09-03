package models.departments;

import models.employees.Employee;
import models.tools.Tool;

import java.util.*;

public class Department {
    protected int id;
    protected String name;
    protected String shortName;
    protected Map <Tool, Integer> storage;
    protected List<Employee> employees;
    public Department(String name, String shortName,int id) {
        this.id = id;
        this.name=name;
        this.shortName=shortName;
        storage=new HashMap<>();
        employees=new ArrayList<>();
    }


    @Override
    public String toString() {
        return shortName.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department department)) return false;
        return Objects.equals(name.toString(), department.name.toString()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    public void takeFromStorage ( Employee employeeFrom, Employee employeeTo, Tool tool, int amount){

    }
}
