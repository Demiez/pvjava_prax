package com.petrenko.prax06;

public class TableLamp extends Lamp {
    String color;
    String material;

    TableLamp(String color, String material, int power) {
        this.color = color;
        this.material = material;
        setLightPowerKv(power);
    }

    public void turnOn(int power) {
        produceLight(power);
    }

    public void turnOff() {
        produceLight(0);
    }
}
