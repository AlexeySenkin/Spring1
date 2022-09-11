import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.senkin.model.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class HomeWorkApp6 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

//        Contact mobile = new Contact(ContactType.HOME_PHONE, "999");
//        Contact email = new Contact(ContactType.HOME_EMAIL, "user@email.ru");
//        Contact address = new Contact(ContactType.HOME_ADDRESS, "Ryazan");
//        List<Contact> contacts = Arrays.asList(mobile,email,address);
//        User user = new User("User1", contacts, "password1");
//        contacts.forEach(contact -> contact.setUser(user));
//
//        entityManager.persist(user);
//
//        Product product1 = new Product("Milk", "900ml", BigDecimal.valueOf(100));
//        Product product2 = new Product("Orange", "1000ml", BigDecimal.valueOf(200));
//        Product product3 = new Product("Bread", "1kg", BigDecimal.valueOf(100));
//        Product product4 = new Product("Meat", "3kg", BigDecimal.valueOf(1000));
//
//        entityManager.persist(product1);
//        entityManager.persist(product2);
//        entityManager.persist(product3);
//        entityManager.persist(product4);
//
//        Customer customer1 = new Customer();
//        customer1.setUser(user);
//
//        entityManager.persist(customer1);
//
//        LineItem lineItem1 = new LineItem();
//        lineItem1.setProduct(product1);
//        lineItem1.setCount(2L);
//        lineItem1.setDescription("!");
//        lineItem1.setCost(product1.getCost());
//        lineItem1.setCustomer(customer1);
//
//        LineItem lineItem2 = new LineItem();
//        lineItem2.setProduct(product2);
//        lineItem2.setCount(3L);
//        lineItem2.setDescription("!");
//        lineItem2.setCost(product2.getCost());
//        lineItem2.setCustomer(customer1);
//
//        entityManager.persist(lineItem1);
//        entityManager.persist(lineItem2);



        Customer customer = entityManager.createQuery("select c from Customer c where id = " + 1, Customer.class).getSingleResult();
        for (LineItem product : customer.getProducts()) {
            System.out.println(product.getProduct().getTitle());
            System.out.println(product.getCost().toString());
        }

        Product product = entityManager.createQuery("select p from Product p where id = " + 1, Product.class).getSingleResult();
        for (LineItem lineItem : product.getLineItems() ) {
            System.out.println(lineItem.getCustomer().getId().toString());

        }

        entityManager.getTransaction().commit();



        entityManager.close();
        entityManagerFactory.close();

    }
}
