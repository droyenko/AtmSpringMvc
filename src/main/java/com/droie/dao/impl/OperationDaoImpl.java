package com.droie.dao.impl;

import com.droie.dao.OperationDao;
import com.droie.entity.Operation;
import com.droie.dao.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OperationDaoImpl implements OperationDao {

    @Autowired
    public NamedParameterJdbcTemplate jdbcTemplate;

    public void save(Operation operation) {
        String sql = "INSERT INTO operation (card_id, time, amount, type) VALUES (:cardId, :time, :amount, :type)";

        jdbcTemplate.update(sql,
                new BeanPropertySqlParameterSource(operation));
    }

    @Override
    public Operation getLastWithdrawalOperation(String cardNumber) {
        String sql = "SELECT * FROM operation WHERE card_id=:number AND type='withdrawal'" +
                "ORDER BY operation_id DESC LIMIT 1";

        return jdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("number", cardNumber),
                new OperationMapper());
    }
}
