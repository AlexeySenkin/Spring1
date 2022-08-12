package ru.senkin;

import java.util.Objects;

public class Product {

    private final int id;
    private final String title;
    private final long cost;

    public Product(int id, String title, long cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && cost == product.cost && Objects.equals(title, product.title);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cost);
    }


}
