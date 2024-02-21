package com.group.libraryapp.dto.day2.sum.response;

import com.group.libraryapp.dto.day2.sum.request.SumRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class SumResponse {

    private int sum = 0;

    public SumResponse(SumRequest request) {
        List<Integer> list = request.getNumbers();
        for (Integer num : list) {
            this.sum += num;
        }
    }

    public int getSum() {
        return sum;
    }
}
