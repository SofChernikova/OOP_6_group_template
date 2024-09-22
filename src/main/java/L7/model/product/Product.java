package L7.model.product;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/***
 * Любой продукт в холодильнике
 */
@Getter
@Setter
@Accessors(chain = true)
public class Product {
    private String productName;
    private ProductType productType;

    /**
     * @apiNote dateOfManufacture - дата изготовления
     *          validUntil - годен до
     */
    private LocalDate dateOfManufacture;
    private LocalDate validUntil;

}
