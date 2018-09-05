package com.droie.service;

import com.droie.entity.Card;

import java.util.List;

public interface CardService {

    void save(Card card);

    Card getById(int id);

    List<Card> findAll();

    void update(Card card);

    void delete(int id);



    Card getCardByNumber(String number);

    int getPin(String number);

    void blockCard(String number);

    String isBlocked(String number);

    int getAttempt(String number);

    String checkPin(Integer pin);
}
