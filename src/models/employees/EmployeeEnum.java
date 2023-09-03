package models.employees;

public enum EmployeeEnum {
    WORKER("Рабочий"), CONTROLLER("Контролер"), STOREKEEPER("Кладовщик");
private String occupation;

    EmployeeEnum(String occupation) {
        this.occupation = occupation;
    }
}
