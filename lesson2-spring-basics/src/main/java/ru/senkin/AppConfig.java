package ru.senkin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("ru.senkin")
public class AppConfig {

//    @Bean(name = "product_repository")
//    public ProductRepository productRepository() {
//        return new ProductRepository();
//    }
//
//    @Bean(name = "cart")
//    @Scope("prototype")
//    public Cart cart(ProductRepository productRepository) {
//        Cart cart = new Cart(productRepository);
//        return cart;
//    }


}
