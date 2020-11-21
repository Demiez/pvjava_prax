package com.petrenko.prax04.modules.account;

import com.petrenko.prax04.interfaces.IBaseBankRate;

public abstract class Account implements IBaseBankRate {
    String name;
    String passportId;
    double balance;
    static int index = 10000;
    String accountNumber;
    double rate;

    // Constructor to set base properties and account
    public Account(String name, String passportId, double initDeposit) {
        this.name = name;
        this.passportId = passportId;
        this.balance = initDeposit;
        setRate();

        // set Account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    // method to generate common account number
    private String setAccountNumber() {
        String  lastTwoOfPassportId = passportId.substring(passportId.length()-2, passportId.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfPassportId + uniqueID + randomNumber;
    }

    public void compound() {
        double AccuredIntrest = balance * (rate/100);
        balance = balance + AccuredIntrest;
        System.out.println("Accured Intrest is: " + AccuredIntrest);
        showBalance();
    }

    // Basic transaction methods
    public void deposit(double deposit) {
        balance = balance + deposit;
        System.out.println("---------------------------------------");
        System.out.println("Deposit of Cash :" + deposit + " is Successful...");
        showBalance();
    }
    public void withdraw(int withdrow) {
        balance = balance - withdrow ;
        System.out.println("---------------------------------------");
        System.out.println("withdrawal of Cash:" + withdrow + " is Successful...");
        showBalance();
    }
    public void transfer(String toWhom, double tranfer) {
        balance = balance - tranfer;
        System.out.println("---------------------------------------");
        System.out.println("Tranfer of Cash: " + tranfer + " is Successfully Transfered to " + toWhom);
        showBalance();
    }
    public void showBalance() {
        System.out.println("Now Your Account Balance Is : " + balance);
        System.out.println("------------------------------------");
    }

    // Show common info for both accounts
    public void showInfo() {

        System.out.println("\nAccount Information:\n");
        System.out.println(
            " Account Name :  " +  name +
                "\n Account Number : " + accountNumber +
                "\n Account Balance : " + balance +
                "\n Intrest Rate :  " + rate
        );
        System.out.println("\n---------------------------------------");
    }
}
