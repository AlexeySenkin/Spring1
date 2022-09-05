import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.senkin.model.Contact;
import ru.senkin.model.ContactType;
import ru.senkin.model.User;

import java.util.Arrays;
import java.util.List;

public class HomeWorkApp6 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();



        Contact mobile = new Contact(ContactType.HOME_PHONE, "999");
        Contact email = new Contact(ContactType.HOME_EMAIL, "user@email.ru");
        Contact address = new Contact(ContactType.HOME_ADDRESS, "Ryazan");

        List<Contact> contacts = Arrays.asList(mobile,email,address);

        User user = new User("User1", contacts, "password1");

        entityManager.getTransaction().begin();

        contacts.forEach(contact -> contact.setUser(user));

        //entityManager.persist(user);

        List<User> users = entityManager.createNamedQuery("findAllUsers", User.class).getResultList();

        for (User user1 : users) {
            user1.getContacts().forEach(System.out::println);
        }

        //entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
