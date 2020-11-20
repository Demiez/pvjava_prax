package com.petrenko.prax04.interfaces;

public interface IBaseBankRate {
    default double getBaseBankRate() {
        return 3.5;
    }
}
