package com.group.libraryapp.repository.day6;

import com.group.libraryapp.dto.day4.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.day4.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.day4.fruit.response.FruitSalesResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class FruitMySqlJdbcRepository implements FruitJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(FruitCreateRequest request) {
//        System.out.println("FruitMySqlRepository.saveFruit");
        String sql = "INSERT INTO fruit (name, warehousingDate, price) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public void updateFruit(FruitUpdateRequest request) {
        String readsql = "SELECT * FROM fruit WHERE id = ?";
        boolean isNotExist = jdbcTemplate.query(readsql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "UPDATE fruit SET isSold = NOT isSold WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    public FruitSalesResponse salesFruit(String name) {
        String readsql = "SELECT * FROM fruit WHERE name = ?";
        boolean isNotExist = jdbcTemplate.query(readsql, (rs, rowNum) -> 0, name).isEmpty();
        if (isNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "SELECT SUM(price) AS total_price, " +
                "SUM(CASE WHEN isSold THEN price ELSE 0 END) AS sales_amount, " +
                "SUM(CASE WHEN isSold THEN 0 ELSE price END) AS not_sales_amount FROM fruit WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name}, (rs, rowNum) -> {
            long salesAmount = rs.getLong("sales_amount");
            long notSalesAmount = rs.getLong("not_sales_amount");

            return new FruitSalesResponse(salesAmount, notSalesAmount);
        });
    }
}
