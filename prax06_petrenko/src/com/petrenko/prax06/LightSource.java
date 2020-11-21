package com.petrenko.prax06;

public interface LightSource {
    boolean exist();
    boolean fade();
    void produceLight(int power);
}
