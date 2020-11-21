package com.petrenko.prax05;

public class ParkApp {

    public static void main(String[] args) {
        Park park = new Park("Shevchenko Park");
        park.addAttraction("Carnival Ride", "8AM-10PM", 7.99f);
        park.addAttraction("Baloon Race", "8AM-8PM", 4.99f);
        park.addAttraction("Hyper Booster", "8AM-8PM", 8.99f);

        park.displayParkInfo();
    }
}
