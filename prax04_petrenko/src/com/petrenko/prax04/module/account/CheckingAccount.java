package com.petrenko.prax04.module.account;

public class CheckingAccount extends Account {
    private int debitCardNumber;
    private int debitCardPin;

    public CheckingAccount(String name, String sSN, double initDeposit) {
        super(name , sSN , initDeposit);

        accountNumber = "2" + accountNumber;
        generateCredentials();
    }

    // set the Base rate
    public void setRate() {
        rate = getBaseBankRate() * .15;

    }

    // Card number and pin generation
    private void generateCredentials()
    {
        debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    }

    // Show Checking Account info
    public void showInfo() {
        System.out.println("Checking Account Created Successfully...");
        super.showInfo();
        System.out.println("Your CHECKING Account Features:\n " +
            "\nDebit Card Number: "+ debitCardNumber +
            "\nDebit Card Pin: " + debitCardPin
        );
    }

}
