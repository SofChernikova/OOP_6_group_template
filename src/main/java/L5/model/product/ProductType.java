package L5.model.product;

/**
 * Тип продукта (мясо, рыба, овощ)
 */
public enum ProductType {
    MEAT("meat"),
    FISH("fish"),
    VEGETABLE("vegetable");

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    public String toValue(){
        return value;
    }
}
