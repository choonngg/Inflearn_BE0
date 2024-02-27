package com.group.libraryapp.domain.fruit;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25, name = "name")
    private String name;
    private Long price;
    private LocalDate warehousingDate;
    private boolean isSold = false;

    public Fruit() {
    }

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public boolean isSold() {
        return isSold;
    }

    public void updateIsSold(boolean isSold) {
        this.isSold = !isSold;
    }
}
