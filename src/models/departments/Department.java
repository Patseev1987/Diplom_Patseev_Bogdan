package models.departments;

import models.employees.Employee;
import models.tools.Tool;

import java.util.*;

public class Department {
    private int id;
    private String name;
    private String shortName;
    private Map <Tool, Integer> storage;
    private List<Employee> employees;

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


    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public Map<Tool, Integer> getStorage() {
        return storage;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
