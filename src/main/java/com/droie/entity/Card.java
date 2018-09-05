package com.droie.entity;

public class Card {

    private int id;
    private String number;
    private boolean blocked;
    private int pin;
    private int invalidAttempts;
    private float balance;

    public Card() {
    }

    public Card(int id, String number, boolean blocked, int pin, int invalidAttempts, float balance) {

        this.id = id;
        this.number = number;
        this.blocked = blocked;
        this.pin = pin;
        this.invalidAttempts = invalidAttempts;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getBlocked() {
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
