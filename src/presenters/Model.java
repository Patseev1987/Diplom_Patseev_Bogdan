package presenters;

import models.employees.Employee;
import models.departments.Department;
import models.tools.Tool;

import java.util.Collection;
import java.util.Map;

public interface Model {
    /**
     * Загружаем подразделения завода
     * @return список подразделений на заводе
     */
    Collection<Department> loadDataBaseWithDepartments();

    /**
     *  Зашружаем базу данных инструмента на заводе
     * @return возвщает коллекцию с инструментом
     */
    Map<Tool,Integer> loadToolDataBaseWithTools();

    Collection<Employee> loadEmployeeDataBaseWithEmployeesInDepartment(Department department);

    /**
     * Добавляем подразделение на заводе
     * @param department подразделение
     */
    void addDepartment (Department department);
    /**
     * Удаляем подразделение на заводе
     * @param department подразделение
     */
    void removeDepartment (Department department);

    /**
     * Добавляем работника в подразделение
     * @param department подразделение
     * @param employee работник
     */
    void addEmployee(Department department, Employee employee);
    /**
     * Удаляем работника в подразделении
     * @param department подразделение
     * @param employee работник
     */
    void removeEmployee(Department department, Employee employee);

    /**
     * Добавляем инструмент в базу (получение на завод)
     * @param tool инструмент
     * @param count количество
     */
    void addTool (Tool tool, int count);

    /**
     * Удаляем инсрумент(списание)
     * @param tool инструмент
     * @param count количество
     * @param department подразделение
     */
    void removeToolInDepartment(Tool tool, int count, Department department);

}
