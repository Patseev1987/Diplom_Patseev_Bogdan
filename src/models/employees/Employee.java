package models.employees;

import models.tools.Tool;
import models.departments.Department;

import java.util.HashMap;
import java.util.Map;

public abstract class Employee {
    protected Map<Tool, Integer> employeeListTool;
    protected String lastName;
    protected String firstName;
    protected String patronymic;
    protected Department department;

    public Employee(String lastName, String firstName, String patronymic, Department department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.department = department;
        employeeListTool = new HashMap<>();
    }

    /**
     * Передать инструмент другому рабочему
     * @param tool инсрумент
     * @param employee рабочий кому передаем
     * @param value какое количество инструмента передаем
     */
    public void giveToolAnotherEmployee(Tool tool, Employee employee, int value) {
        if (!this.employeeListTool.containsKey(tool)) {
            throw new RuntimeException("Такого иструмента у рабочего нет! Передача невозможна.");
        }
        int realValue = this.removeToolFromList(tool, value);
        employee.addToolInList(tool, realValue);
    }

    /**
     * Взять инсрумент у другого рабочего
     *
     * @param tool инструмент
     * @param employee рабочий у кого берем инструмент
     * @param value количество сколько берем инсрумента
     */
    public void takeToolAnotherEmployee(Tool tool, Employee employee, int value) {
        if (!employee.employeeListTool.containsKey(tool)) {
            throw new RuntimeException(employee + " не инмеет такого интрумента");
        }
        if (this.employeeListTool.containsKey(tool)) {
            int temp = this.employeeListTool.get(tool);
            int realValue = employee.removeToolFromList(tool, value);
            addToolInList(tool, realValue + temp);
        } else {
            int realValue = employee.removeToolFromList(tool, value);
            addToolInList(tool, realValue);
        }
    }

    /**
     * Сдать инструмент в кладовую подразделения
     *
     * @param tool  инструмент
     * @param value количество
     */
    public void giveToolInStorage(Tool tool, int value) {
        int temp = department.getStorageList().get(tool);
        if (temp > 0) {
            int realValue = removeToolFromList(tool, value);
            department.changeValueInStorageList(tool, temp + realValue);
        } else {
            int realValue = removeToolFromList(tool, value);
            department.changeValueInStorageList(tool, realValue);
            removeToolFromList(tool, value);
        }
    }

    /**
     * Взять инструмент в кладовой
     *
     * @param tool  инструмент
     * @param value количество инструмента, котороенеобходимо взять
     */
    public void takeToolInStorage(Tool tool, int value) {
        if (!department.getStorageList().containsKey(tool)) {
            throw new RuntimeException("В кладовой " + department + "нет такого инструмента: " + tool);
        }
        int temp = department.getStorageList().get(tool);
        if (temp >= value) {
            addToolInList(tool, value);
            department.changeValueInStorageList(tool, temp - value);
        } else {
            System.out.println("В кладовой " + department + " есть " + temp + "\nБудет выдано :" + temp);
            addToolInList(tool, temp);
            department.changeValueInStorageList(tool, temp - temp);
        }
    }

    /**
     * Добавляет инструмент в список рабочего
     *
     * @param tool  инструмент
     * @param value количество инструмента
     */
    private void addToolInList(Tool tool, int value) {
        if (employeeListTool.containsKey(tool)) {
            int temp = employeeListTool.get(tool);
            employeeListTool.put(tool, temp + value);
        } else {
            employeeListTool.put(tool, value);
        }
    }

    /**
     * Удаляет инструмент из списка рабочего
     *
     * @param tool  инструмент
     * @param value количество инструмента, коорое сдает рабочий
     * @return количество инструмента, который сда рабочий
     */
    private int removeToolFromList(Tool tool, int value) {
        if (!employeeListTool.containsKey(tool)) {
            throw new RuntimeException("За рабочим этот инструмент не числится: " + tool);
        }
        int temp = employeeListTool.get(tool);
        if (temp >= value) {
            employeeListTool.put(tool, temp - value);
            return value;
        } else {
            System.out.println("Нельзя сдать больше, чем числится за рабочим!\nБудет сдано " + temp);
            employeeListTool.put(tool, temp - temp);
            return temp;
        }
    }

    public void showToolLit (){
        for (Map.Entry<Tool, Integer> entry : employeeListTool.entrySet()) {
            int count = 0;
            System.out.println(count+". "+entry);
        }
    }
}


