package models.employees;

import models.tools.Tool;
import models.departments.Department;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;


public abstract class Employee {
    private int id;
    private Map<Tool, Integer> tools;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Department department;
    private LocalDate joinDate;
    private String schemaName;

    public String getSchemaName() {
        return schemaName;
    }
}


