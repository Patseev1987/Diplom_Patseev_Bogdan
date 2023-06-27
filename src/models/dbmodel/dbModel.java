package models.dbmodel;

import models.departments.Department;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class dbModel implements DataLoadable{
    @Override
    public List<Department> getListDepartment() {
        List<Department> result = new ArrayList<>();
        return result;
    }
}
