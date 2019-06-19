package com.sb.inherit.abs;

public class VeryDifferentAccount implements Account {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void monthEnd() {

    }

    @Override
    public void monthMiddle() {
        double b = getBalance();
        if(b < 500) {
            //send email about low balance
        }
    }
}
