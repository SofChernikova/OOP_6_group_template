package L5.service;

import L5.exception.InvalidDateException;
import L5.model.product.Product;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Класс для работы с продуктом
 */
public class ProductService {

    /**
     * паттерн YYYY-MM-DD
     */
    private static final Pattern DATE_PATTER =
            Pattern.compile("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])");

    /**
     * Проверяем дату, если валидная, то присваиваем
     * @param product - продукт, на котором необходимо поставить срок годности
     * @param date - дата изготовления
     */
    public void setDateOfManufacture(Product product, String date){
        isDataValid(date);

        product.setDateOfManufacture(LocalDate.parse(date));
    }

    public void setValidUntilDate(Product product, String date){
        isDataValid(date);

        product.setValidUntil(LocalDate.parse(date));
    }

    private void isDataValid(String data){
        if (!DATE_PATTER.matcher(data).matches()){
            throw new InvalidDateException("Формат даты: YYYY-MM-DD");
        }
    }
}
