package com.group.libraryapp.dto.day2.date.response;

import com.group.libraryapp.dto.day2.date.request.DateRequest;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateResponse {

    private LocalDate localDate;
    private DayOfWeek week;
    private String dayOfWeek;

    public DateResponse(DateRequest request) {
        this.localDate = LocalDate.parse(request.getDate());
        this.week = localDate.getDayOfWeek();
        this.dayOfWeek = week.toString().substring(0, 3);
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
