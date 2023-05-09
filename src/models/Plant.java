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
    public Collection<Department> loadUnits() {
        return listDepartments;
    }

    @Override
    public Map<Tool, Integer> loadToolDataBaseForPlant() {
        return plantListTool;
    }

    @Override
    public Collection<Employee> loadEmployeeDataBaseInDepartment(Department department) {
        return department.getEmployeesList();
    }

    @Override
    public void addUnit(Department department) {
        if (!listDepartments.contains(department)) {
            listDepartments.add(department);
        } else {
            throw new RuntimeException("Такое подразделение уже есть!");
        }
    }


}
