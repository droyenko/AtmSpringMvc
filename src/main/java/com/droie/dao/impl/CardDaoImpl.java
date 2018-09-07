package com.droie.dao.impl;

import com.droie.dao.CardDao;
import com.droie.entity.Card;
import com.droie.dao.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDaoImpl implements CardDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void save(Card card) {
        String sql = "INSERT INTO card (card_number, blocked, pin, invalid_pin_attempts, balance) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, card.getNumber(), card.getBlocked(), card.getPin(), card.getInvalidAttempts(), card.getBalance());
    }

    public Card getById(int card_id) {
        String sql = "SELECT * FROM card WHERE card_id=?";
        return jdbcTemplate.queryForObject(sql, new CardMapper(), card_id);
    }

    public List<Card> findAll() {
        String sql = "SELECT * FROM card";
        return jdbcTemplate.query(sql, new CardMapper());
    }

    public void update(Card card) {
        String sql = "UPDATE card SET card_number=?, blocked=?, pin=?, invalid_pin_attempts=?, balance=? WHERE card_id=?";
        jdbcTemplate.update(sql, card.getNumber(), card.getBlocked(), card.getPin(), card.getInvalidAttempts(), card.getBalance(), card.getId());
    }

    public void delete(int card_id) {
        String sql = "DELETE FROM card WHERE card_id=?";
        jdbcTemplate.update(sql, card_id);
    }


    @Override
    public Card getCardByNumber(String number) {
        String sql = "SELECT * FROM card WHERE card_number=?";
        return jdbcTemplate.queryForObject(sql, new CardMapper(), number);
    }

    @Override
    public String getPin(String number) {
        String sql = "SELECT pin FROM card WHERE card_number=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {number}, String.class);
    }

    @Override
    public void blockCard(String number) {
        String sql = "UPDATE card SET blocked=true, invalid_pin_attempts=0 WHERE card_number=?";
        jdbcTemplate.update(sql, number);
    }

    @Override
    public Boolean isBlocked(String number) {
        String sql = "SELECT blocked FROM card WHERE card_number=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[] {number}, Boolean.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int getAttempt(String number) {
        String sql = "SELECT invalid_pin_attempts FROM card WHERE card_number=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {number}, Integer.class);
    }

    @Override
    public void setAttempt(String number, int value) {
        String sql = "UPDATE card SET invalid_pin_attempts=? WHERE card_number=?";
        jdbcTemplate.update(sql, value, number);
    }

    @Override
    public Float getBalance(String number) {
        String sql = "SELECT balance FROM card WHERE card_number=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {number}, Float.class);
    }

    @Override
    public void setBalance(String number, float value) {
        String sql = "UPDATE card SET balance=? WHERE card_number=?";
        jdbcTemplate.update(sql, value, number);
    }
}
