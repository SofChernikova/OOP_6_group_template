package L5.service;

import L5.exception.InvalidDateException;
import L5.model.product.Product;
import L5.model.product.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки корректности работы сервиса
 */
class ProductServiceTest {

    private static final LocalDate DATE = LocalDate.of(2024, 8, 10);
    private static final String VALID_DATE = "2024-08-10";
    private static final String INVALID_DATE = "2024/08/10";
    private final Product product = new Product()
            .setProductName("product")
            .setProductType(ProductType.FISH);
    private final ProductService productService = new ProductService();

    @Test
    @DisplayName("Дата изготовления валидная, ошибки не будет")
    void setDateOfManufacturePositiveTest() {
        productService.setDateOfManufacture(product, VALID_DATE);

        assertEquals(product.getDateOfManufacture(), DATE);
    }

    @Test
    @DisplayName("Дата истечения срока годности валидная, ошибки не будет")
    void setValidUntilDatePositiveTest() {
        assertDoesNotThrow(() -> productService.setValidUntilDate(product, VALID_DATE));

        assertEquals(product.getValidUntil(), DATE);
    }

    @Test
    @DisplayName("Ошибка валидации даты изготовления")
    void setDateOfManufactureNegativeTest() {
        assertThrows(InvalidDateException.class,
                () -> productService.setDateOfManufacture(product, INVALID_DATE));
    }

    @Test
    @DisplayName("Ошибка валидации даты истечения срока годности")
    void setValidUntilDateNegativeTest() {
        assertThrows(InvalidDateException.class,
                () -> productService.setValidUntilDate(product, INVALID_DATE));
    }
}