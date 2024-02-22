package com.group.libraryapp.controller.day4;

import com.group.libraryapp.dto.day4.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.day4.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.day4.fruit.response.FruitSalesResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Day4Controller {

    private final JdbcTemplate jdbcTemplate;

    public Day4Controller(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        String readsql = "SELECT * FROM fruit WHERE id = ?";
        boolean isNotExist = jdbcTemplate.query(readsql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "UPDATE fruit SET isSold = NOT isSold WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @GetMapping("/api/v1/fruit")
    public FruitSalesResponse salesFruit(@RequestParam String name) {
        String readsql = "SELECT * FROM fruit WHERE name = ?";
        boolean isNotExist = jdbcTemplate.query(readsql, (rs, rowNum) -> 0, name).isEmpty();
        if (isNotExist) {
            throw new IllegalArgumentException();
        }

        AtomicLong salesAmount = new AtomicLong();
        AtomicLong notSalesAmount = new AtomicLong();
        String sql = "SELECT * FROM fruit WHERE name = ?";
        jdbcTemplate.query(sql, new Object[]{name}, (rs, rowNum) -> {
            boolean isSold = rs.getBoolean("isSold");
            long price = rs.getLong("price");

            if (name.equals("사과")) {
                salesAmount.addAndGet(isSold ? price : 0L);
                notSalesAmount.addAndGet(isSold ? 0L : price);
            }

            return null;
        });

        return new FruitSalesResponse(salesAmount.get(), notSalesAmount.get());
    }

}
