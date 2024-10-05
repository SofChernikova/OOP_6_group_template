package L5.model.shelf;

import L5.model.product.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MeatShelf extends Shelf {

    private List<Product> productList = new ArrayList<>();

    @Override
    public ShelfType getShelfType() {
        return ShelfType.MEAT_SHELF;
    }

    @Override
    public void putProductOnShelf(Product product) {
        super.log("Кладем продукт на мясную полку..");
        this.productList.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return this.productList;
    }

    @Override
    public void clearShelf() {
        this.productList =  new ArrayList<>();
    }

}
