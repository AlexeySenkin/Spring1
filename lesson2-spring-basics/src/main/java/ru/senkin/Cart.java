package ru.senkin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("cart")
@Scope("prototype")
public class Cart {

    private final ProductRepository productRepository;

    List<Product> productsInCart;

    @Autowired
    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        productsInCart = new ArrayList<>();
        productsInCart.addAll(productRepository.getProducts());
    }

    public void printProducts() {
        System.out.println(productsInCart.toString());
    }

    public void deleteProductById(int repId) {
        for (int i = 0; i < productsInCart.size(); i++) {
            if (productsInCart.get(i).getId() == repId) {
                productsInCart.remove(i);
            }
        }
    }

    public void addProductById(int repId) {
        productsInCart.add(productRepository.getProductById(repId));
    }

}
