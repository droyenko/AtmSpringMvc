package com.droie.dao.impl;

import com.droie.dao.OperationDao;
import com.droie.entity.Operation;
import com.droie.dao.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OperationDaoImpl implements OperationDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void save(Operation operation) {
        String sql = "INSERT INTO operation (card_id, time, amount, type) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, operation.getCardId(), operation.getTime(), operation.getAmount(), operation.getType());
    }

    @Override
    public Operation getLastWithdrawalOperation(String cardNumber) {
        String sql = "SELECT * FROM operation WHERE card_id=? AND type='withdrawal' ORDER BY operation_id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new OperationMapper(), cardNumber);
    }
}
