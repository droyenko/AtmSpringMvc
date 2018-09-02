package com.droie.mapper;

import com.droie.entity.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper implements RowMapper<Card> {
    public Card mapRow(ResultSet resultSet, int i) throws SQLException {
        Card card = new Card();
        card.setId(resultSet.getString("card_id"));
        card.setBlocked(resultSet.getBoolean("blocked"));
        card.setPin(resultSet.getInt("pin"));
        card.setInvalidAttempts(resultSet.getInt("invalid_pin_attempts"));
        card.setBalance(resultSet.getFloat("balance"));
        return card;
    }
}
