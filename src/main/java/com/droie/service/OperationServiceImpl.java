package com.droie.service;

import com.droie.dao.OperationDao;
import com.droie.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    public OperationDao operationDao;

    public void save(Operation operation) {
        operationDao.save(operation);
    }

    public Operation getById(int id) {
        return operationDao.getById(id);
    }

    public List<Operation> findAll() {
        return operationDao.findAll();
    }

    public void update(Operation operation) {
        operationDao.update(operation);
    }

    public void delete(int id) {
        operationDao.delete(id);
    }
}
