package com.group.libraryapp.assignment.dto.response;

import java.time.LocalDate;

public class FruitListResponse {

    private String name;
    private Long price;
    private LocalDate warehousingDate;

    public FruitListResponse(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
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
}
