package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Neuron {
    private ArrayList<Double> weight; // neuron input weights or synaptic connections
    private ArrayList<Double> delta; //neuron delta values
    private double output; //output value
    private double gain;//Gain value
    private double wgain;//Weight gain value

    Neuron() {
        output = 0;
        gain = 0;
        wgain = 0;
    }

    public void setOutput(double output) {
        this.output = output;
    }
    public double getOutput() {
        return output;
    }

    public void setGain(double gain) {
        this.gain = gain;
    }
    public double getGain() {
        return gain;
    }

    public void setWgain(double wgain) {
        this.wgain = wgain;
    }
    public double getWgain() {
        return wgain;
    }

    public void setWeight(int pos, double x) {
        weight.set(pos, x);
    }
    public double getWeight(int pos) {
        return weight.get(pos);
    }

    public void setDelta(int pos, double x) {
        delta.set(pos, x);
    }
    public double getDelta(int pos) {
        return delta.get(pos);
    }

    void create(int inputCount) {
        double random;//to get random number
        weight = new ArrayList<>(inputCount);
        delta = new ArrayList<>(inputCount);
        RandomDouble rd = new RandomDouble(-0.5, 0.5);
        for(int i=0; i < inputCount; i++) {
            //get a random number between -0.5 and 0.5
            random = rd.getDoubleAndChangeSign();
            weight.set(i, random);
            delta.set(i, 0.d);
        }
        gain = 1;

        random = rd.getDouble();
        rd.getDoubleAndChangeSign();
        wgain = random;

    }
}
