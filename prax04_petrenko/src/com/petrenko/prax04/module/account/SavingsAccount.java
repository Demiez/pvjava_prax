package com.petrenko.prax04.module.account;

public class SavingsAccount extends Account {
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    public SavingsAccount(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);

        accountNumber = "1" + accountNumber;
        generateDepositBox();
    }

    // set the rate
    public void setRate() {
        rate = getBaseBankRate() * .25;
    }

    // Deposit box generation
    private void generateDepositBox() {
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    // Show Savings Account Info
    public void showInfo() {
        System.out.println("Savings Account Created Successfully...");
        super.showInfo();
        System.out.println(" Your SAVINGS Account Features:\n " +
            "\nSafety Deposit Box ID : " + safetyDepositBoxID +
            "\nSafety Deposit Box Key: " + safetyDepositBoxKey
        );
    }
}
