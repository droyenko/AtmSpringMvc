package com.droie.service;

import com.droie.entity.Card;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CardService {

    Card getCardByNumber(String number);

    String getPin(String number);

    void blockCard(String number);

    float getBalance(String number);

    String isBlocked(String number);

    int getAttempt(String number);

    String checkPin(Integer pin, String cardNumber, HttpServletRequest request);

    String processWithdrawal(float balance, String cardNumber);
}
