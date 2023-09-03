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
    protected ToolType type;

    public Tool(String toolCode, String name                                                     ,String manufacturer, boolean purchasedTool, ToolType type) {
        this.toolCode = toolCode;
        this.name = name;
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

    public String getToolCode() {
        return toolCode;
    }

    public String getName() {
        return name;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public Boolean getPurchasedTool() {
        return purchasedTool;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPurchasedTool(Boolean purchasedTool) {
        this.purchasedTool = purchasedTool;
    }

    public void setType(ToolType type) {
        this.type = type;
    }

    public String getType() {
        return type.toString();
    }
}
