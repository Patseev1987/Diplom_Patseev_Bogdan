package models.tools;

public enum ToolType {
    DRILL("Сверло"),HOLDER("Державка"),INSERT("Сменная пластина"),MILLING("Фреза"),TURING("Резец"),MEASURING("Мерительный"),HOB("Червячная фреза"),ABRASIVE("Абразивный");
    private String translate;

    ToolType(String translate) {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return translate;
    }
}
