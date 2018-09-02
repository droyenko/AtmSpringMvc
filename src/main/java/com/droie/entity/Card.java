package com.droie.entity;

public class Card {

    private String id;
    private boolean blocked;
    private int pin;
    private int invalidAttempts;
    private float balance;

    public Card() {
    }

    public Card(String id, boolean blocked, int pin, int invalidAttempts, float balance) {

        this.id = id;
        this.blocked = blocked;
        this.pin = pin;
        this.invalidAttempts = invalidAttempts;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getInvalidAttempts() {
        return invalidAttempts;
    }

    public void setInvalidAttempts(int invalidAttempts) {
        this.invalidAttempts = invalidAttempts;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
