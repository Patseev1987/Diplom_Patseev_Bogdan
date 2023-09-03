package models.tools;

public class Drill extends Tool implements Sharpenable {
    private boolean isSharpen;

    public Drill(String toolCode, String name, String designation, String manufacturer, boolean purchasedTool, ToolType type) {
        super(toolCode, name, designation, manufacturer, purchasedTool, type);
        this.isSharpen = true;
    }


    @Override
    public boolean getIsSharpen() {
        return isSharpen;
    }

    @Override
    public void setIsSharpen(boolean sharpen) {
        this.isSharpen = sharpen;
    }
}
