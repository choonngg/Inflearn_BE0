package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.dto.day2.calculator.request.CalculatorReqeust;
import com.group.libraryapp.dto.day2.calculator.response.CalculatorResponse;
import com.group.libraryapp.dto.request.CalculatorAddRequest;
import com.group.libraryapp.dto.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    /*
    @GetMapping("/add")
    public int addTwoNumbers(int number1, int number2) {
        return number1 + number2;
    }
    */

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

//    @GetMapping("/fruit")
//    public Fruit fruit() {
//        return new Fruit("바나나", 2000L);
//    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
}
