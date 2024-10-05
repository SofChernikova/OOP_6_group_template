package L5.model.shelf;

/**
 * Тип полки (мясная, рыбная, овощная)
 */
public enum ShelfType {
    MEAT_SHELF("meat"),
    FISH_SHELF("fish"),
    VEGETABLE_SHELF("vegetable");

    private final String value;

    ShelfType(String value) {
        this.value = value;
    }

    public String toValue(){
        return value;
    }
}
