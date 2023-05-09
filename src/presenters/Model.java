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
    Collection<Department> loadUnits();

    /**
     *  Зашружаем базу данных инструмента на заводе
     * @return возвщает коллекцию с инструментом
     */
    Map<Tool,Integer> loadToolDataBaseForPlant();

    Collection<Employee> loadEmployeeDataBaseInDepartment(Department department);

    /**
     * Добавляем подразделение на заводе
     * @param department подразделение
     */
    void addUnit (Department department);
}
