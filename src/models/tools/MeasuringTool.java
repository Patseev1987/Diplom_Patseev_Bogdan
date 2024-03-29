package models.tools;

import java.time.LocalDate;

public class MeasuringTool extends Tool{
    private LocalDate checkDate;
    public MeasuringTool(String toolCode, String name, String manufacturer, boolean purchasedTool, ToolType type) {
        super(toolCode, name, manufacturer, purchasedTool, type);
        this.checkDate = LocalDate.now();
    }

    public LocalDate getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDate checkDate) {
        this.checkDate = checkDate;
    }
}
