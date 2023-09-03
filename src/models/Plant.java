package models;


import models.departments.Department;
import models.employees.Employee;
import models.tools.Tool;
import presenters.Model;

import java.util.*;

public class Plant implements Model {
private List<Department> departments;
 private List<Transaction> transactions;
 private String name;

 public Plant(String name) {
  this.name = name;
  this.departments = new ArrayList<>();
  this.transactions = new ArrayList<>();
 }

 public boolean takeToolFromAnotherDepartment(Tool tool, int amount,Department departmentFrom, Department departmentTo, Employee employeeFrom, Employee employeeTo){

  return true;
 }
}
