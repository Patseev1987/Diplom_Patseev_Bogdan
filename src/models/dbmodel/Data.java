package models.dbmodel;

import models.departments.Department;
import models.employees.Employee;
import models.tools.Tool;


import java.sql.*;

public class Data {

    public void takeToolFromAnotherDepartment(Tool tool, int amount, Department departmentFrom, Department departmentTo, Employee employeeFrom, Employee employeeTo) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diplom",
                "root", "Root1234"); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("USE diplom; SELECT " + employeeFrom.getSchemaName() + ".amount FROM " + employeeFrom.getSchemaName() + "WHERE " + employeeFrom.getSchemaName());
            try {
                connection.setAutoCommit(false);


                connection.commit();
            } catch (Exception e) {
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new SQLException("Не удалось установить соединение с базой данных.");
        }
    }


    private String getAmountFromEmployee(Employee employee, Tool tool) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(employee.getSchemaName());
        sb.append(".amount FROM ");
        sb.append(employee.getSchemaName());
        sb.append(" WHERE toolCodeId=");
        sb.append(tool.getToolCode());
        return sb.toString();
    }

    private String
}
