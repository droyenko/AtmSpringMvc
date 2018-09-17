package com.droie.dao.impl;

import com.droie.dao.CardDao;
import com.droie.entity.Card;
import com.droie.dao.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CardDaoImpl implements CardDao {

    @Autowired
    public NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Card getCardByNumber(String number) {
        String sql = "SELECT * FROM card WHERE card_number=:number";

        return jdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("number", number),
                new CardMapper());
    }

    @Override
    public String getPin(String number) {
        String sql = "SELECT pin FROM card WHERE card_number=:number";

        return jdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("number", number),
                String.class);
    }

    @Override
    public void blockCard(String number) {
        String sql = "UPDATE card SET blocked=true WHERE card_number=:number";

        jdbcTemplate.update(sql,
                new MapSqlParameterSource("number", number));
    }

    @Override
    public Boolean isBlocked(String number) {
        String sql = "SELECT blocked FROM card WHERE card_number=:number";
        try {
            return jdbcTemplate.queryForObject(sql,
                    new MapSqlParameterSource("number", number),
                    Boolean.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int getAttempt(String number) {
        String sql = "SELECT invalid_pin_attempts FROM card WHERE card_number=:number";

        return jdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("number", number),
                Integer.class);
    }

    @Override
    public void setAttempt(String number, int value) {
        String sql = "UPDATE card SET invalid_pin_attempts=:value WHERE card_number=:number";

        jdbcTemplate.update(sql,
                new MapSqlParameterSource("value", value)
                        .addValue("number", number));
    }

    @Override
    public Float getBalance(String number) {
        String sql = "SELECT balance FROM card WHERE card_number=:number";

        return jdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("number", number),
                Float.class);
    }

    @Override
    public void setBalance(String number, float balance) {
        String sql = "UPDATE card SET balance=:balance WHERE card_number=:number";
        jdbcTemplate.update(sql,
                new MapSqlParameterSource("balance", balance)
                        .addValue("number", number));
    }
}
