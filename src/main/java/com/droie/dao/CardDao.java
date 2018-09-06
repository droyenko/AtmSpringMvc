package com.droie.dao;

import com.droie.entity.Card;

import java.util.List;

public interface CardDao {

    void save(Card card);

    Card getById(int id);

    List<Card> findAll();

    void update(Card card);

    void delete(int id);


    Card getCardByNumber(String number);

    String getPin(String number);

    void blockCard(String number);

    Boolean isBlocked(String number);

    int getAttempt(String number);

    void setAttempt(String number, int value);

    Float getBalance(String number);

    void setBalance(String number, float value);
}
