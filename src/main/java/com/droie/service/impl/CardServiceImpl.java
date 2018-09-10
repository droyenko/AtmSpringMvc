package com.droie.service.impl;

import com.droie.dao.CardDao;
import com.droie.dao.OperationDao;
import com.droie.entity.Card;
import com.droie.entity.Operation;
import com.droie.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    public CardDao cardDao;

    @Autowired
    public OperationDao operationDao;

    @Autowired
    public AuthServiceImpl authService;

    @Override
    public Card getCardByNumber(String number) {
        return cardDao.getCardByNumber(number);
    }

    @Override
    public String getPin(String number) {
        return cardDao.getPin(number);
    }

    @Override
    public void blockCard(String number) {
        cardDao.blockCard(number);
    }

    @Override
    public int getAttempt(String number) {
        return cardDao.getAttempt(number);
    }

    @Override
    public float getBalance(String number) {
        return cardDao.getBalance(number);
    }

    @Override
    public String isBlocked(String number) {
        String message = null;
        Boolean isBlocked = cardDao.isBlocked(number);

        if (isBlocked == null) {
            message = "There is no card with number: " + number;
        } else if (isBlocked) {
            message = "Card is blocked";
        } else {
            authService.setLocalCardNumber(number);
        }

        return message;
    }

    @Override
    public String checkPin(Integer pin, String cardNumber, HttpServletRequest request) {
        String message = null;
        String actualPin = cardDao.getPin(cardNumber);

        String enteredPinMd5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(pin.toString());

        if (!enteredPinMd5.equals(actualPin)) {
            int attempt = cardDao.getAttempt(cardNumber);
            if (attempt < 3) {
                cardDao.setAttempt(cardNumber, attempt + 1);
                message = String.format("Wrong PIN. You have %d attempts left", 3 - attempt);
            } else {
                cardDao.blockCard(cardNumber);
                message = "You have entered wrong PIN 4 times. Your card is blocked";
            }
        } else {
            cardDao.setAttempt(cardNumber, 0);
            authService.setAuthenticated(request);
        }
        return message;
    }

    @Override
    public String processWithdrawal(float withdrawalAmount, String cardNumber) {
        String message = null;
        Card card = cardDao.getCardByNumber(cardNumber);
        float actualBalance = card.getBalance();

        if (withdrawalAmount > actualBalance) {
            message = "You don't have sufficient amount on your account";
        } else {
            operationDao.save(new Operation(
                    cardNumber,
                    new Timestamp(new Date().getTime()),
                    withdrawalAmount,
                    "withdrawal"
            ));
            cardDao.setBalance(cardNumber, actualBalance - withdrawalAmount);
        }

        return message;
    }
}
