package L7.model.shelf;

import L7.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class FishShelf extends Shelf{

    private List<Product> productList = new ArrayList<>();
    @Override
    public ShelfType getShelfType() {
        return ShelfType.FISH_SHELF;
    }

    @Override
    public void putProductOnShelf(Product product) {
        super.log("Кладем продукт на рыбную полку..");
        this.productList.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return this.productList;
    }

    @Override
    public void clearShelf() {
        this.productList = new ArrayList<>();
    }
}
