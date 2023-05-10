package models;

import models.employees.Employee;
import models.tools.Tool;
import models.departments.Department;
import presenters.Model;

import java.util.*;

public class Plant implements Model {
    private Map<Tool, Integer> plantListTool;
    List<Department> listDepartments;

    public Plant() {
        this.plantListTool = new HashMap<>();
        this.listDepartments = new ArrayList<>();
    }

    @Override
    public Collection<Department> loadDataBaseWithDepartments() {
        return listDepartments;
    }

    @Override
    public Map<Tool, Integer> loadToolDataBaseWithTools() {
        return plantListTool;
    }

    @Override
    public Collection<Employee> loadEmployeeDataBaseWithEmployeesInDepartment(Department department) {
        return department.getEmployeesList();
    }

    @Override
    public void addDepartment(Department department) {
        if (!listDepartments.contains(department)) {
            listDepartments.add(department);
        } else {
            throw new RuntimeException("Такое подразделение уже есть!");
        }
    }

    @Override
    public void removeDepartment(Department department) {

    }

    @Override
    public void addEmployee(Department department, Employee employee) {

    }

    @Override
    public void removeEmployee(Department department, Employee employee) {

    }

    @Override
    public void addTool(Tool tool, int count) {

    }

    @Override
    public void removeToolInDepartment(Tool tool, int count, Department department) {
if (!department.getStorageList().containsKey(tool)){
    throw new RuntimeException("Такого инструмента в подразделние нет! Списание невозможно");
}
int temp
    }


}
