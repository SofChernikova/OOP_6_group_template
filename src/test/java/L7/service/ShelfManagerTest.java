package L7.service;

import L7.model.product.Product;
import L7.model.product.ProductType;
import L7.model.shelf.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ShelfManagerTest {

    private static final Map<String, Shelf> shelves = new HashMap<>();
    private final ShelfManager shelfManager = new ShelfManager(shelves);
    private static final LocalDate DATE = LocalDate.of(2024, 8, 10);
    private static final String PRODUCT_NAME = "randomProduct";
    private static final List<Product> products = new ArrayList<>(3);

    @BeforeAll
    static void setUp() {
        shelves.put(ShelfType.FISH_SHELF.toValue(), new FishShelf());
        shelves.put(ShelfType.MEAT_SHELF.toValue(), new MeatShelf());
        shelves.put(ShelfType.VEGETABLE_SHELF.toValue(), new VegetableShelf());

        products.add(
                new Product()
                        .setProductName(PRODUCT_NAME)
                        .setProductType(ProductType.FISH)
                        .setDateOfManufacture(DATE)
        );
        products.add(
                new Product()
                        .setProductName(PRODUCT_NAME)
                        .setProductType(ProductType.MEAT)
                        .setDateOfManufacture(DATE)
        );
        products.add(
                new Product()
                        .setProductName(PRODUCT_NAME)
                        .setProductType(ProductType.VEGETABLE)
                        .setDateOfManufacture(DATE)
        );

    }

    @AfterEach
    void clearShelves() {
        shelves.values().forEach(Shelf::clearShelf);
    }

    @Test
    @DisplayName("Проверим, что все продукты на нужных полках")
    void distributionOfProductsPositiveTest() {
        for (Product product : products) {
            assertDoesNotThrow(() ->
                    shelfManager.putProductOnShelf(
                            product,
                            shelves.get(product.getProductType().toValue()))
            );
        }

        for (Shelf shelf: shelves.values()){
            assertTrue(checkProductOnShelf(shelf));
        }
    }

    @Test
    @DisplayName("Проверим, что если мы вдруг перепутали полки, то наш менеджер все равно положит на правильную")
    void distributionOfProductsWithWrongShelfPositiveTest(){
        assertDoesNotThrow(() -> shelfManager.putProductOnShelf(
                products.getFirst(),
                shelves.get("meat")
        ));

        assertEquals(shelves.get("meat").getProducts().size(), 0);

        assertEquals(shelves.get("fish").getProducts().size(), 1);
        assertEquals(shelves.get("fish").getProducts().getFirst().getProductType(),
                products.getFirst().getProductType());
    }

    private boolean checkProductOnShelf(Shelf shelf) {
        return shelf.getProducts().size() == 1
                && shelf.getProducts().getFirst().getProductType().toValue()
                .equals(shelf.getShelfType().toValue());
    }

}