package models.tools;

public class Drill extends Tool implements Sharpenable{
    public Drill(String toolCode, String name, String designation, String manufacturer, boolean purchasedTool, String type) {
        super(toolCode, name, designation, manufacturer, purchasedTool, type);
    }

    @Override
    public boolean sharpen() {
        return true;
    }
}
