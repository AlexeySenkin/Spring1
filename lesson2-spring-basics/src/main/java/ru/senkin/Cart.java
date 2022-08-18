package ru.senkin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cart")
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
