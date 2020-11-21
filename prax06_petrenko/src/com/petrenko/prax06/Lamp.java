package com.petrenko.prax06;

public class Lamp implements LightSource {
    private Boolean isExistingNow;
    private Boolean isWorkingNow;
    private int lightPowerKv;
    public String form;

    Lamp() {
        this.form = "round";
        this.lightPowerKv = 220;
        this.exist();
    }

    @Override
    public void exist() {
        this.isExistingNow = true;
    }

    @Override
    public void fade() {
        this.isExistingNow = false;
        this.lightPowerKv = 0;
        this.form = "broken";
    }

    @Override
    public void produceLight(int power) {
        this.isWorkingNow = true;
        if(isExistingNow && power <= lightPowerKv) {
            System.out.println("Producing light");
        }
        if(power > lightPowerKv) {
            this.isWorkingNow = false;
            System.out.println("Lamp has broken, too much electric power");
            this.fade();
        }
        if(power == 0) {
            this.isWorkingNow = false;
            System.out.println("It is dark now");
        }
    }

    private String getExistingStatus() {
        return this.isExistingNow ? "yes" : "no";
    }

    private String getWorkingStatus() {
        return this.isWorkingNow ? "yes" : "no";
    }

    public void setLightPowerKv(int power) {
        this.lightPowerKv = power;
    }

    public void getLampStats() {
        System.out.printf("Lamp stats: \t Form: %s \t Exists: %s \t Works: %s  \t Light Power: %d \n", this.form, this.getExistingStatus(), this.getWorkingStatus(), this.lightPowerKv);
    }
}
