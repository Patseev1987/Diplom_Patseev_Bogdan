package models.tools;

public class TuringTool extends Tool implements Sharpenable {
    private boolean isSharpen;

    public TuringTool(String toolCode, String name, String manufacturer, boolean purchasedTool, ToolType type) {
        super(toolCode, name, manufacturer, purchasedTool, type);
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
