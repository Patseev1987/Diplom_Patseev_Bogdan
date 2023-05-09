package models.departments;

public enum ListDepartments {
    WORKSHOP19("Цех 19"),
    WORKSHOP22("Цех 22"),
    WORKSHOP43("Цех 43"),
    STORAGEDEPARTMENT("Центральный инструментальный склад"),
    SHARPENDEPARTMENT("Заточное подразделение");
    private String departmentName;

   private ListDepartments(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return departmentName;
    }
}
