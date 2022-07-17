package by.epam.training.entity;

import by.epam.training.type.*;

import java.util.Random;

public class Cargo {
    private PortName destinationPortName;
    private int cargoWeight;
    private final int MAX_CARGO_WEIGHT = 30;//tonna

    public Cargo() {
        destinationPortName = PortName.getRandomPortName();
        cargoWeight = setRandomWeight();
    }

    private int setRandomWeight() {
        int min = 1;
        int max = MAX_CARGO_WEIGHT;

        return min + (int) (Math.random() * ((max - min) + 1));

    }

    public PortName getDestinationPortName() {
        return destinationPortName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cargo[ ").append("destinationPortName=").append(destinationPortName);
        sb.append(", cargoWeight=").append(cargoWeight).append(" ]");

        return sb.toString();
    }
}
