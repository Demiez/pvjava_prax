package com.petrenko.prax04;

import com.petrenko.prax04.modules.banking.Banking;

public class BankAccountsApp {

    public static void main(String[] args) {
        Banking banking = new Banking();
        banking.service();
    }
}
