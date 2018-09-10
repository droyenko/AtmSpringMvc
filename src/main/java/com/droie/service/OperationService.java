package com.droie.service;

import com.droie.entity.Operation;

public interface OperationService {

    void save(Operation operation);

    Operation getLastWithdrawalOperation(String cardNumber);
}
