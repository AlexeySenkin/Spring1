import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.senkin.model.Product;
import java.util.Optional;


public class main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        ProductRepository productRepository = new ProductRepository(entityManagerFactory);

        productRepository.save(new Product("Milk",100));
        productRepository.save(new Product("Orange",200));
        productRepository.save(new Product("Bread",50));
        productRepository.save(new Product("Eggs",150));
        productRepository.save(new Product("Meat",1000));
        System.out.println(productRepository.findAll());

        Optional<Product> optionalProduct = productRepository.findById(1L);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setCost(99);
            productRepository.save(product);
        } else {
            System.out.println("ProductById not found");
        }
        System.out.println(productRepository.findAll());

        productRepository.deleteById(2L);
        System.out.println(productRepository.findAll());

    }
}
