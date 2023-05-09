package models.tools;

import java.util.Objects;

public abstract class Tool {
    /**
     * Шифр инструмента "****-****"
     */
    protected String toolCode;

    /**
     * Наименование
     */
    protected String name;
    /**
     * Обозначение
     */
    protected String designation;
    /**
     * Фирма производитель
     */
    protected String manufacturer;
    /**
     * покупной или собстенного изготовления
     */
    protected Boolean purchasedTool;
    /**
     * Тип инструмента
     */
    protected String type;

    public Tool(String toolCode, String name, String designation,String manufacturer, boolean purchasedTool, String type) {
        this.toolCode = toolCode;
        this.name = name;
        this.designation = designation;
        this.manufacturer = manufacturer;
        this.purchasedTool = purchasedTool;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tool tool)) return false;
        return Objects.equals(toolCode, tool.toolCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toolCode);
    }
}
