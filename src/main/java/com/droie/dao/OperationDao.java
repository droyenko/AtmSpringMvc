package com.droie.dao;

import com.droie.entity.Operation;

import java.util.List;

public interface OperationDao {

    void save(Operation operation);

    Operation getById(int id);

    List<Operation> findAll();

    void update(Operation operation);

    void delete(int id);

    Operation getLastWithdrawalOperation(String cardNumber);
}
