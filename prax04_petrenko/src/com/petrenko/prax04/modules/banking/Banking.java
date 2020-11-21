package com.petrenko.prax04.modules.banking;
import com.petrenko.prax04.modules.account.CheckingAccount;
import com.petrenko.prax04.modules.account.SavingsAccount;

import java.util.Scanner;

public class Banking {
    Scanner sc = new Scanner(System.in);
    public void service(){
        while(true) {
            System.out.println("-----------------------------------------");
            System.out.println("Account Opening Menu: \n\n1. Savings Account \n2. Checking Account \n0. Exit \n\nPlease choose Account Type(1/2):");
            int choice = sc.nextInt();
            if(choice==1) {
                System.out.println("\n---------------------------------------");
                System.out.println("Enter Full Name: ");
                sc.nextLine();
                String fullName = sc.nextLine();
                System.out.println("\n---------------------------------------");
                System.out.println("Enter 6 digit Passport Number:");
                String passportId = sc.nextLine();
                System.out.println("\n---------------------------------------");
                System.out.println("Enter Deposit Amount:");
                int deposit = sc.nextInt();
                SavingsAccount savingsAccount = new SavingsAccount(fullName, passportId, deposit);
                System.out.println("\n**********************************************");
                savingsAccount.showInfo();
                savingsAccount.compound();

                while(true) {
                    System.out.println("\nTransaction Menu: \n\n1. Deposit \n2. Withdraw \n3. Money Tranfer \n0. Exit Transaction Menu \n\n Select Transaction Number: ");
                    int ch = sc.nextInt();
                    if(ch==1) {
                        System.out.println("---------------------------------------");
                        System.out.println("Enter Deposit Amount: ");
                        double dep = sc.nextDouble();
                        savingsAccount.deposit(dep);
                    }
                    if(ch==2) {
                        System.out.println("---------------------------------------");
                        System.out.println("Enter Withdraw Amount: ");
                        int wid = sc.nextInt();
                        savingsAccount.withdraw(wid);
                    }
                    if(ch==3) {
                        System.out.println("---------------------------------------");
                        System.out.println("Enter Transferee Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter Transfer Amount: ");
                        double transferAmount = sc.nextDouble();
                        savingsAccount.transfer(name, transferAmount);
                    }
                    if(ch==0) {break;}
                }
            }

            if(choice==2) {
                System.out.println("\n---------------------------------------");
                System.out.println("Enter Full Name: ");
                sc.nextLine();
                String fullName = sc.nextLine();
                System.out.println("\n---------------------------------------");
                System.out.println("Enter 6 digit Passport Number:");
                String passportId = sc.nextLine();
                System.out.println("\n---------------------------------------");
                System.out.println("Enter Opening Deposit Amount:");
                int deposit = sc.nextInt();
                CheckingAccount checkingAccount = new CheckingAccount(fullName, passportId, deposit );
                System.out.println("**********************************************");
                checkingAccount.showInfo();
                checkingAccount.compound();

                while(true) {
                    System.out.println("\nTransaction Menu: \n\n1. Deposit \n2. Withdraw \n3. Money Tranfer \n0. Exit Transaction Menu\n\nSelect Transaction Number: ");
                    int ch = sc.nextInt();
                    if(ch==1) {
                        System.out.println("---------------------------------------");
                        System.out.println("Enter Deposit Amount: ");
                        double dep = sc.nextDouble();
                        checkingAccount.deposit(dep);
                    }
                    if(ch==2) {
                        System.out.println("---------------------------------------");
                        System.out.println("Enter Withdrow Amount: ");
                        int wid = sc.nextInt();
                        checkingAccount.withdraw(wid);
                    }
                    if(ch==3) {
                        System.out.println("---------------------------------------");
                        System.out.println("Enter Transferee Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter Transfer Amount: ");
                        double transferAmount = sc.nextDouble();
                        checkingAccount.transfer(name, transferAmount);
                    }
                    if(ch==0) {break;}
                }
            }
            if(choice==0) {
                System.exit(0);
            }
        }
    }
}
