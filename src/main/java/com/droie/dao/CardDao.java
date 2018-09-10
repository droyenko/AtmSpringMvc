package com.droie.dao;

import com.droie.entity.Card;

public interface CardDao {

    Card getCardByNumber(String number);

    String getPin(String number);

    void blockCard(String number);

    Boolean isBlocked(String number);

    int getAttempt(String number);

    void setAttempt(String number, int value);

    Float getBalance(String number);

    void setBalance(String number, float value);
}
