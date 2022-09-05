package ru.senkin.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findAllUsers", query = "select u from User u"),
        @NamedQuery(name = "findUserById", query = "select u from User u where u.id = : id"),
        @NamedQuery(name = "deleteUserById", query = "delete from User u where u.id = : id")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @OneToMany(mappedBy = "user",
    cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.MERGE},
    orphanRemoval = true)
    private List<Contact> contacts;

    @Column(nullable = false, length = 1024)
    private String password;

    public User(String username, List<Contact> contacts, String password) {
        this.username = username;
        this.contacts = contacts;
        this.password = password;
    }


}