package models.tools;

import java.util.Scanner;

public class InsertTool extends Tool{
    Scanner scanner = new Scanner(System.in);
    protected String compatibilityHolder;

    public InsertTool(String toolCode, String name, String designation, String manufacturer, boolean purchasedTool, String type, String compatibility) {
        super(toolCode, name, designation, manufacturer, purchasedTool, type);
        this.compatibilityHolder =compatibility;
    }
}
