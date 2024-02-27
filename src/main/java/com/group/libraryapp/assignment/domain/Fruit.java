package com.group.libraryapp.assignment.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private LocalDate warehousingDate;
    private Boolean isSold = false;

    public Fruit() {
    }

    public Fruit(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
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

    public Boolean getIsSold() {
        return isSold;
    }

    public void updateIsSold(boolean isSold) {
        this.isSold = true;
    }
}
