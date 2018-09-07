package com.droie.service;

import com.droie.entity.Card;

import java.util.List;

public interface CardService {


    String getLocalCardNumber(String key);

    void save(Card card);

    Card getById(int id);

    List<Card> findAll();

    void update(Card card);

    void delete(int id);



    Card getCardByNumber(String number);

    String getPin(String number);

    void blockCard(String number);

    float getBalance(String number);

    String isBlocked(String number);

    int getAttempt(String number);

    String checkPin(Integer pin);

    String processWithdrawal(float balance, String cardNumber);
}
