package com.droie.dao.impl;

import com.droie.dao.OperationDao;
import com.droie.entity.Operation;
import com.droie.dao.mapper.OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationDaoImpl implements OperationDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public void save(Operation operation) {
        String sql = "INSERT INTO operation (card_id, time, amount, type) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, operation.getCardId(), operation.getTime(), operation.getAmount(), operation.getType());
    }

    public Operation getById(int operation_id) {
        String sql = "SELECT * FROM operation WHERE operation_id=?";
        return jdbcTemplate.queryForObject(sql, new OperationMapper(), operation_id);
    }

    public List<Operation> findAll() {
        String sql = "SELECT * FROM operation";
        return jdbcTemplate.query(sql, new OperationMapper());
    }

    public void update(Operation operation) {
        String sql = "UPDATE operation SET card_id=?, time=?, amount=?, type=? WHERE operation_id=?";
        jdbcTemplate.update(sql, operation.getCardId(), operation.getTime(), operation.getAmount(), operation.getType(), operation.getId());
    }

    public void delete(int operation_id) {
        String sql = "DELETE FROM operation WHERE operation_id=?";
        jdbcTemplate.update(sql, operation_id);
    }

    @Override
    public Operation getLastWithdrawalOperation(String cardNumber) {
        String sql = "SELECT * FROM operation WHERE card_id=? AND type='withdrawal' ORDER BY operation_id DESC LIMIT 1";
        return jdbcTemplate.queryForObject(sql, new OperationMapper(), cardNumber);
    }
}
