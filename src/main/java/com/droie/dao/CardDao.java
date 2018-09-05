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

    int getPin(String number);

    void blockCard(String number);

    Boolean isBlocked(String number);

    int getAttempt(String number);
}
