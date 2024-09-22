package L7.service;

import L7.exception.WrongShelfException;
import L7.model.product.Product;
import L7.model.product.ProductType;
import L7.model.shelf.Shelf;
import L7.model.shelf.ShelfType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class ShelfManager {

    /**
     * Список полок
     */
    private final Map<String, Shelf> shelves;
    private static final String ERROR_MESSAGE = "Во время выполнения функции произошла ошибка: %s";

    /**
     * Сравниваем тип продукта и полки, отлавливаем ошибку
     *
     * @param product - продукт, который хотим положить на полку
     * @param shelf   - полка
     */
    public void putProductOnShelf(Product product, Shelf shelf) {
        try {
            isRightShelf(product.getProductType(), shelf.getShelfType());
            shelf.putProductOnShelf(product);
        } catch (WrongShelfException e) {
            log.error(ERROR_MESSAGE.formatted(e.getMessage()));
        } finally {
            if (shelves.get(product.getProductType().toValue()).getProducts().isEmpty()){
                shelves.get(product.getProductType().toValue())
                        .putProductOnShelf(product);
                log.info("Менеджер положил продукт на полку!");
            }
        }
    }

    /**
     * Если значения енамов не совпадают, выкидывается ошибка
     *
     * @param productType - тип продукта
     * @param shelfType   - тип полки
     */
    private void isRightShelf(ProductType productType, ShelfType shelfType) {
        if (!productType.toValue().equals(shelfType.toValue())) {
            throw new WrongShelfException("Попытка положить товар не на ту полку!");
        }
    }
}
