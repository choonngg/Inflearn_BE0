package com.group.libraryapp.assignment.dto.response;

public class FruitSoldResponse {

    private Long salesAmount;
    private Long notSalesAmount;

    public FruitSoldResponse(Long salesAmount, Long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public Long getSalesAmount() {
        return salesAmount;
    }

    public Long getNotSalesAmount() {
        return notSalesAmount;
    }
}
