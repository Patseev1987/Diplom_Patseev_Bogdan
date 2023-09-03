package models.dbmodel;

import models.departments.Department;
import models.employees.*;
import models.tools.*;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            throw new RuntimeException("Не удалось установить соединение с базой данных.");
        }
    }

    /**
     * Возвращает SQL запрос на кол-во конретного инструмента у работника
     * @param employee работник
     * @param tool инструмент
     * @return SQL запрос
     */
    private String getAmountFromEmployeeQuery(Employee employee, Tool tool) {
        StringBuilder sb = new StringBuilder();
        sb.append("USE diplom; ");
        sb.append("SELECT ");
        sb.append(employee.getSchemaName());
        sb.append(".amount FROM ");
        sb.append(employee.getSchemaName());
        sb.append(" WHERE toolCodeId=");
        sb.append(tool.getToolCode());
        return sb.toString();
    }

    /**
     * Возвращает SQL запрос на кол-во конретного инструмента на складе в цеху
     * @param department цех
     * @param tool инструмент
     * @return SQL запрос
     */
    private String getAmountFromDepartmentStorageQuery(Department department, Tool tool) {
        StringBuilder sb = new StringBuilder();
        sb.append("USE diplom; ");
        sb.append("SELECT ");
        sb.append(department.getShortName());
        sb.append(".amount FROM ");
        sb.append(department.getStorage());
        sb.append(" WHERE toolCodeId=");
        sb.append(tool.getToolCode());
        return sb.toString();
    }

    /**
     * Возвращает SQL запрос создание таблицы с интрументом и количесвом у рабочего или цеха
     * @param tableName имя таблицы
     * @return SQL запрос
     */
    private String getCreateTableWithToolsAmountQuery(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append("USE diplom; ");
        sb.append("CREATE TABLE IF NOT EXIST diplom.");
        sb.append(tableName);
        sb.append(" ( toolCodeId VARCHAR(15) NOT NULL, amount INT NOT NULL, PRIMARY KEY (toolCodeID), ");
        sb.append(" UNIQUE INDEX toolCodeId_UNIQUE (toolCodeId ASC) VISIBLE, ");
        sb.append("CONSTRAINT 19_toolCode FOREIGN KEY (toolCodeId) REFERENCES diplom.tools (toolCode) ");
        sb.append("ON DELETE NO ACTION  ON UPDATE NO ACTION);");
        return sb.toString();
    }

    /**
     * Возвращает SQL запрос на кол-во инструмента
     *
     * @param tableName Имя таблицы
     * @return SQL запрос
     */
    private String getToolAmountQuery(String tableName) {
        StringBuilder sb = new StringBuilder();
        sb.append("USE diplome; ");
        sb.append("SELECT * FROM diplom.");
        sb.append(tableName);
        sb.append(" JOIN diplom.tools ON toolCodeId=toolCode");
        return sb.toString();
    }

    /**
     * Метод возврящает список с инструментом, который закреплен за рабочим
     *
     * @param employee Рабочий
     * @return список инструмента
     */
    public Map<Tool, Integer> getToolFromEmployee(Employee employee) {
        Map<Tool, Integer> tools = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diplom",
                "root", "Root1234"); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getToolAmountQuery(employee.getSchemaName()));
            while (resultSet.next()) {
                ToolType toolType = ToolType.valueOf(resultSet.getString("type"));
                switch (toolType) {
                    case HOB ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.HOB), resultSet.getInt("amount"));
                    case DRILL ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.DRILL), resultSet.getInt("amount"));
                    case HOLDER ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.HOLDER), resultSet.getInt("amount"));
                    case INSERT ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.INSERT), resultSet.getInt("amount"));
                    case MEASURING ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.MEASURING), resultSet.getInt("amount"));
                    case MILLING ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.MILLING), resultSet.getInt("amount"));
                    case TURING ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.TURING), resultSet.getInt("amount"));
                    case ABRASIVE ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.ABRASIVE), resultSet.getInt("amount"));
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось установить соединение с базой данных!");
        }
        return tools;
    }


    /**
     * Метод возвращает список с инструментом, который находятся на складе в цеху
     *
     * @param department цех
     * @return список инструмента на складе в цеху
     */
    public Map<Tool, Integer> getToolFromDepartment(Department department) {
        Map<Tool, Integer> tools = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diplom",
                "root", "Root1234"); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getToolAmountQuery(department.getShortName()));
            while (resultSet.next()) {
                ToolType toolType = ToolType.valueOf(resultSet.getString("type"));
                switch (toolType) {
                    case HOB ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.HOB), resultSet.getInt("amount"));
                    case DRILL ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.DRILL), resultSet.getInt("amount"));
                    case HOLDER ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.HOLDER), resultSet.getInt("amount"));
                    case INSERT ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.INSERT), resultSet.getInt("amount"));
                    case MEASURING ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.MEASURING), resultSet.getInt("amount"));
                    case MILLING ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.MILLING), resultSet.getInt("amount"));
                    case TURING ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.TURING), resultSet.getInt("amount"));
                    case ABRASIVE ->
                            tools.put(new Hob(resultSet.getString("toolCode"),
                                    resultSet.getString("name"), resultSet.getString("manufacturer"),
                                    resultSet.getBoolean("purchasedTool"), ToolType.ABRASIVE), resultSet.getInt("amount"));
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось установить соединение с базой данных!");
        }
        return tools;
    }

    /**
     * Возвращает список цехов на предприятии
     * @return список цехов
     */
    public List<Department> getDepartments (){
        List<Department> departments = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diplom",
                "root", "Root1234"); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Use diplom; SELECT * FROM diplom.departments");
            while (resultSet.next()){
                departments.add(new Department(resultSet.getString("name"),
                        resultSet.getString("shortName"),resultSet.getInt("id")));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось установить соединение с базой данных.");
        }
        return departments;
    }

    /**
     * Возвращает SQL запрос на работников цеха
     * @param department цех
     * @return SQL запрос
     */
    private String getEmployeesFromDepartmentQuery (Department department){
        StringBuilder sb = new StringBuilder();
        sb.append("Use diplom; ");
        sb.append("SELECT * FROM diplom.departments WHERE department=");
        sb.append(department.getShortName());
        return sb.toString();
    }

    /**
     * Метод возвращает список работников цеха
     * @param department цех
     * @return список работников
     */
    public List<Employee> getEmployeesFromDepartment (Department department){
        List<Employee> employees = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/diplom",
                "root", "Root1234"); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getEmployeesFromDepartmentQuery(department));
            while (resultSet.next()){
                EmployeeEnum employeeEnum = EmployeeEnum.valueOf(resultSet.getString("occupation"));
                switch (employeeEnum){
                    case WORKER -> employees.add(new Worker(resultSet.getString("lastname"),
                            resultSet.getString("firstname"),resultSet.getString("patronimyc"),
                            department,resultSet.getDate("joinDate").toLocalDate(),EmployeeEnum.WORKER));
                    case CONTROLLER -> employees.add(new Controller(resultSet.getString("lastname"),
                            resultSet.getString("firstname"),resultSet.getString("patronimyc"),
                            department,resultSet.getDate("joinDate").toLocalDate(),EmployeeEnum.CONTROLLER));
                    case STOREKEEPER -> employees.add(new Storekeeper(resultSet.getString("lastname"),
                            resultSet.getString("firstname"),resultSet.getString("patronimyc"),
                            department,resultSet.getDate("joinDate").toLocalDate(),EmployeeEnum.STOREKEEPER));
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось установить соединение с базой данных.");
        }
        return employees;
    }

}
