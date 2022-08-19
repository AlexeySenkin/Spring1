package ru.senkin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HomeWorkApp {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart1 = context.getBean(Cart.class);
        Cart cart2 = context.getBean(Cart.class);
        Cart cart3 = context.getBean(Cart.class);

        cart1.printProducts();
        cart2.printProducts();
        cart3.printProducts();

        cart1.deleteProductById(0);
        cart2.deleteProductById(1);
        cart3.deleteProductById(2);

        cart1.printProducts();
        cart2.printProducts();
        cart3.printProducts();

        cart1.addProductById(0);
        cart2.addProductById(1);
        cart3.addProductById(2);

        cart1.printProducts();
        cart2.printProducts();
        cart3.printProducts();
    }
}
