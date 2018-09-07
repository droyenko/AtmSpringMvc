package com.droie.dao.mapper;

import com.droie.entity.Operation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationMapper implements RowMapper<Operation> {
    public Operation mapRow(ResultSet resultSet, int i) throws SQLException {
        Operation operation = new Operation();
        operation.setId(resultSet.getInt("operation_id"));
        operation.setCardId(resultSet.getString("card_id"));
        operation.setTime(resultSet.getTimestamp("time"));
        operation.setAmount(resultSet.getFloat("amount"));
        operation.setType(resultSet.getString("type"));
        return operation;
    }
}
