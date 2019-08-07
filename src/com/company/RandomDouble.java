package com.company;

import java.util.Random;

public class RandomDouble {
    private Random r = new Random();
    private double min;
    private double max;
    private double sign = -1;

    public RandomDouble(double x, double y) {
        min = x;
        max = y;
    }

    private void changeSign() {
        sign *= -1;
    }

    public double getDoubleAndChangeSign() {
        double random = getDouble();
        random *= sign;
        changeSign();
        return random;
    }

    public double getDoubleAndChangeSign(double x, double y) {
        min = x;
        max = y;
        return getDoubleAndChangeSign();
    }

    public double getDouble() {
        return min + r.nextDouble() * (max - min);
    }

    public double getDouble(double x, double y) {
        min = x;
        max = y;
        return getDouble();
    }
}
