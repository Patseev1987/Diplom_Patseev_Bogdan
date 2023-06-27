package models;

import models.dbmodel.dbModel;
import models.employees.Employee;
import models.tools.Tool;
import models.departments.Department;
import presenters.Model;

import java.util.*;

public class Plant implements Model {
    private Map<Tool, Integer> plantListTool;
    List<Department> listDepartments;

    dbModel model = new dbModel();

    public Plant() {
        this.plantListTool = new HashMap<>();
        this.listDepartments = new ArrayList<>();
    }
public List<Department> loadListDepartments (){
        // This method should load list with departments from bd.model
   return model.getListDepartment();
}


}
