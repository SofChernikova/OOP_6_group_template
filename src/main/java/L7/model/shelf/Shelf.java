package L7.model.shelf;

import L7.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@NoArgsConstructor
@Getter
@Slf4j
public abstract class Shelf {

    public abstract ShelfType getShelfType();
    public abstract void putProductOnShelf(Product product);
    public abstract List<Product> getProducts();
    public abstract void clearShelf();
    public void log(String message){
        log.info(message);
    };


}
