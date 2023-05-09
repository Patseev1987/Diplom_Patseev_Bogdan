package models.departments;

import models.employees.Employee;
import models.tools.Tool;

import java.util.*;

public abstract class Department {
    protected ListDepartments name;
    protected Map <Tool, Integer> storageList;
    protected Collection<Employee> employeesList;
    public Department(String name) {
        this.name = ListDepartments.valueOf(name);
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

    public void setStorageList(Map<Tool, Integer> storageList) {
        this.storageList = storageList;
    }

    /**
     * Изменяем значение в базе подразделения
     * @param tool инструмент
     * @param newValue новое количество
     */
    public void changeValueInStorageList (Tool tool, int newValue){
          storageList.put(tool,newValue);
        }


    public String getName() {
        return name.toString();
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
