import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Products> listOfProducts;

    public ProductManager() {
        this.listOfProducts = new ArrayList<>();
    }

    public int addProduct(Products p) {
        this.listOfProducts.add(p);
        return this.listOfProducts.size();
    }

    public int count() {
        return this.listOfProducts.size();
    }

    public Products getProduct(int index) {
        if (index < 0 || index >= count()) {
            return null;
        }
        return this.listOfProducts.get(index);
    }

    public boolean removeProduct(int id) {
        int index = -1;
        for (int i = 0, n = count(); i < n; i++) {
            if (this.listOfProducts.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != 1) {
            this.listOfProducts.remove(index);
            return true;
        }
        return false;
    }
}
