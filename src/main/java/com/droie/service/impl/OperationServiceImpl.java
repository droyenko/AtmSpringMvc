package com.droie.service.impl;

import com.droie.dao.OperationDao;
import com.droie.entity.Operation;
import com.droie.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    public OperationDao operationDao;

    public void save(Operation operation) {
        operationDao.save(operation);
    }

    @Override
    public Operation getLastWithdrawalOperation(String cardNumber) {
        return operationDao.getLastWithdrawalOperation(cardNumber);
    }
}
