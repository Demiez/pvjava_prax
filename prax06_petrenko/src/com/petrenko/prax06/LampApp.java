package com.petrenko.prax06;

public class LampApp {

    public static void main(String[] args) {
        TableLamp lamp = new TableLamp("black", "plastic", 220);

        lamp.turnOn(110);
        lamp.getLampStats();

        lamp.turnOff();
        lamp.getLampStats();

        lamp.turnOn(230);
        lamp.getLampStats();
    }
}
