package com.group.libraryapp.dto.day2.calculator.response;

import com.group.libraryapp.dto.day2.calculator.request.CalculatorReqeust;

public class CalculatorResponse {

    private int add;
    private int minus;
    private int multiply;

    public CalculatorResponse(CalculatorReqeust reqeust) {
        this.add = reqeust.getNum1() + reqeust.getNum2();
        this.minus = reqeust.getNum1() - reqeust.getNum2();
        this.multiply = reqeust.getNum1() * reqeust.getNum2();
    }

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }
}
