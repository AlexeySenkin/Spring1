package ru.senkin;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Repository("product_repository")
public class ProductRepository {
    List<Product> products = new ArrayList<>();

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
        products.add(new Product(1, "Milk", 10));
        products.add(new Product(2, "Bread", 5));
        products.add(new Product(3, "Eggs", 30));
        products.add(new Product(4, "Meat", 100));
        products.add(new Product(5, "Orange", 10));
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public void deleteProductById(int id) {
        products.remove(id);
    }

    public void clearAllProduct() {
        products.clear();
    }

    public void fillNewProduct() {
        init();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepository that = (ProductRepository) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + products +
                '}';
    }
}
