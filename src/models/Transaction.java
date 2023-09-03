package models;

import models.dbmodel.Data;
import models.departments.Department;
import models.employees.Employee;
import models.tools.Tool;



public class Transaction {
    private long id;
    private Department departmentFrom;
    private Department departmentTo;
    private Employee employeeFrom;
    private Employee employeeTo;
    private Tool tool;
    private int amount;

    private Data dataBase;

    /**
     *
     * @param id Номер транзакции
     * @param departmentFrom Подразделение откуда переводят
     * @param departmentTo Подразделение куда переводят
     * @param employeeFrom Работник кто переводит
     * @param employeeTo Работник кому переводят
     * @param tool Инструмент
     * @param amount Колличество
     */
    public Transaction(long id, Department departmentFrom, Department departmentTo, Employee employeeFrom, Employee employeeTo, Tool tool, int amount) {
        this.id = id;
        this.departmentFrom = departmentFrom;
        this.departmentTo = departmentTo;
        this.employeeFrom = employeeFrom;
        this.employeeTo = employeeTo;
        this.tool = tool;
        this.amount = amount;
    }

}
