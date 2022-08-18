package ru.senkin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HomeWorkApp {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart1 = context.getBean("cart", Cart.class);
        Cart cart2 = context.getBean("cart", Cart.class);
        Cart cart3 = context.getBean("cart", Cart.class);


    }
}
