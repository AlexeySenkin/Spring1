package ru.senkin.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal cost;

    public Product(String title, BigDecimal cost) {
        this.title = title;
        this.cost = cost;
    }

}
