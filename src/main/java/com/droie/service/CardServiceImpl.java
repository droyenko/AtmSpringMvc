package com.droie.service;

import com.droie.dao.CardDao;
import com.droie.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    public CardDao cardDao;

    public void save(Card card) {
        cardDao.save(card);
    }

    public Card getById(int id) {
        return cardDao.getById(id);
    }

    public List<Card> findAll() {
        return cardDao.findAll();
    }

    public void update(Card card) {
        cardDao.update(card);
    }

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
    public boolean isBlocked(String number) {
        return cardDao.isBlocked(number);
    }

    @Override
    public int getAttempt(String number) {
        return cardDao.getAttempt(number);
    }

    public boolean checkCard(String number) {
        Card card = getCardByNumber(number);
        return (card != null && !card.getBlocked());
    }
}
