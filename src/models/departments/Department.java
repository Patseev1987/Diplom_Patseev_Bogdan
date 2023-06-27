package models.departments;

import models.employees.Employee;
import models.tools.Tool;

import java.util.*;

public class Department {
    protected int id;
    protected String name;
    protected String shortName;
    protected Map <Tool, Integer> storageList;
    protected Collection<Employee> employeesList;
    public Department(String name, String shortName,int id) {
        this.id = id;
        this.shortName=name;
        this.shortName=shortName;
        storageList=new HashMap<>();
        employeesList=new ArrayList<>();
    }

    public Collection<Employee> getEmployeesList() {
        return employeesList;
    }

    public void addEmployeesInList(Employee employee) {
        if(!employeesList.contains(employee)) {
            employeesList.add(employee);
        }else{
            throw new RuntimeException("Такой работник уже есть");
        }
    }

    public Map<Tool, Integer> getStorageList() {
        return storageList;
    }


    @Override
    public String toString() {
        return name.toString();
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
}
