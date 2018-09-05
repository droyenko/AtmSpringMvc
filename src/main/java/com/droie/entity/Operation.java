package com.droie.entity;

import java.sql.Timestamp;

public class Operation {

    private int id;
    private String cardId;
    private Timestamp time;
    private float amount;
    private String type;

    public Operation() {
    }

    public Operation(String cardId, Timestamp time, float amount, String type) {

        this.cardId = cardId;
        this.time = time;
        this.amount = amount;
        this.type = type;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
