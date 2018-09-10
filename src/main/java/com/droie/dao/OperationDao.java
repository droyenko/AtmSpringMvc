package com.droie.dao;

import com.droie.entity.Operation;

public interface OperationDao {

    void save(Operation operation);

    Operation getLastWithdrawalOperation(String cardNumber);
}
