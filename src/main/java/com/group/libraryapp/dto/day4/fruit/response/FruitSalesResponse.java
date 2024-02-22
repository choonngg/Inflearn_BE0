package com.group.libraryapp.dto.day4.fruit.response;

public class FruitSalesResponse {

    private long salesAmount = 0;
    private long notSalesAmount = 0;

    public FruitSalesResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
