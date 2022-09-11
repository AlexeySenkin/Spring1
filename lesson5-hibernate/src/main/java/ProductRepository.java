import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import ru.senkin.model.Product;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private final EntityManagerFactory entityManagerFactory;

    public ProductRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Optional<Product> findById(long id) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       try {
           Product product = entityManager.find(Product.class,id);
           return Optional.ofNullable(product);
       } finally {
           entityManager.close();
      }
    }

    public List<Product> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("select p from Product p", Product.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void save(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (product.getId() == null) {
                entityManager.persist(product);
            } else {
                entityManager.merge(product);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        finally {
            entityManager.close();
        }
    }

    public void deleteById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete from Product p where p.id = " + id ).executeUpdate();
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }

    }

}
