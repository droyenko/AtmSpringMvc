package com.droie.service.impl;

import com.droie.dao.CardDao;
import com.droie.entity.Card;
import com.droie.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    public CardDao cardDao;

    private ThreadLocal<String> localCardNumber = new ThreadLocal<>();

    @Override
    public void save(Card card) {
        cardDao.save(card);
    }

    @Override
    public Card getById(int id) {
        return cardDao.getById(id);
    }

    @Override
    public List<Card> findAll() {
        return cardDao.findAll();
    }

    @Override
    public void update(Card card) {
        cardDao.update(card);
    }

    @Override
    public void delete(int id) {
        cardDao.delete(id);
    }

    @Override
    public Card getCardByNumber(String number) {
        return cardDao.getCardByNumber(number);
    }

    @Override
    public int getPin(String number) {
        return cardDao.getPin(number);
    }

    @Override
    public void blockCard(String number) {
        cardDao.blockCard(number);
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
            localCardNumber.set(number);
        }

        return message;
    }

    @Override
    public int getAttempt(String number) {
        return cardDao.getAttempt(number);
    }

    @Override
    public String checkPin(Integer pin) {
        String cardNumber = localCardNumber.get();
        Integer actualPin = cardDao.getPin(cardNumber);

        UUID a = UUID.fromString(String.valueOf(pin));
        UUID b = UUID.fromString(String.valueOf(actualPin));

        if (b.equals(a)) {

        }
        return "";
    }
}
