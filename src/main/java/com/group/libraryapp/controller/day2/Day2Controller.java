package com.group.libraryapp.controller.day2;

import com.group.libraryapp.dto.day2.calculator.request.CalculatorReqeust;
import com.group.libraryapp.dto.day2.calculator.response.CalculatorResponse;
import com.group.libraryapp.dto.day2.date.request.DateRequest;
import com.group.libraryapp.dto.day2.date.response.DateResponse;
import com.group.libraryapp.dto.day2.sum.request.SumRequest;
import com.group.libraryapp.dto.day2.sum.response.SumResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class Day2Controller {

    @GetMapping("/api/v1/calc")
    public CalculatorResponse calculatorTwoNumbers(CalculatorReqeust reqeust) {
        return new CalculatorResponse(reqeust);
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DateResponse dayOfTheWeek(DateRequest request) {
        return new DateResponse(request);
    }

    @PostMapping("/api/v1/sum")
    public int sumNumbers(@RequestBody SumRequest request) {
        SumResponse response = new SumResponse(request);

        return response.getSum();
    }
}
