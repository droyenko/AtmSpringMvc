package com.droie.service;

import com.droie.entity.Operation;

import java.util.List;

public interface OperationService {

    void save(Operation operation);

    Operation getById(int id);

    List<Operation> findAll();

    void update(Operation operation);

    void delete(int id);
}