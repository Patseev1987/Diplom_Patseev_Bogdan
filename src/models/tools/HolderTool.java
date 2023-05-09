package models.tools;

public class HolderTool extends Tool {
    protected String compatibilityInsert;
    public HolderTool(String toolCode, String name, String designation, String manufacturer, boolean purchasedTool, String type, String compatibilityInsert) {
        super(toolCode, name, designation, manufacturer, purchasedTool, type);
        this.compatibilityInsert=compatibilityInsert;
    }
}
