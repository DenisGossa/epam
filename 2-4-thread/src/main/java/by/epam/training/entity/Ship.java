package by.epam.training.entity;

import by.epam.training.type.OperationStatus;
import by.epam.training.type.PortName;

import java.util.*;

public class Ship {
    private final int MIN_SHIP_CAPACITY = 100;
    private final int MAX_SHIP_CAPACITY = 250;
    private int maxCapacity;//containers onboard count
    private int shipID;
    private int operationQuote;


    private final static int LOADFACTOR = 4/10;
    PortName currentPortName;
    PortName nextPortName;

    private final List<Cargo> list = new LinkedList<Cargo>();

    public Ship(int shipID) {
        this.maxCapacity = setRandomCapacity();
        operationQuote = maxCapacity*LOADFACTOR; //simulation of max count operation
        this.shipID = shipID;
        for (int i = 0; i < maxCapacity; i++) {
            list.add(new Cargo());
        }
    }

    public List<Cargo> getList() {
        return list;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }


    private int setRandomCapacity() {
        return MIN_SHIP_CAPACITY + (int) (Math.random() * ((MAX_SHIP_CAPACITY - MIN_SHIP_CAPACITY) + 1));
    }

    public void setCurrentPortName(PortName currentPortName) {
        this.currentPortName = currentPortName;
    }

    public void setNextPortName(PortName nextPortName) {
        this.nextPortName = nextPortName;
    }

    public CargoWrapper takeCargofromShip() {
        System.out.println("Unloading ship "+shipID);
        Cargo cargo = null;
        int operationResult;
        System.out.println("Ship Cargo list.size BEFORE" + list.size());
        if (list.size() > 0) {
            int indexResult = findCargoAtShip();
            if (indexResult >= 0) {
                cargo = list.remove(indexResult);
                System.out.println("FIND " + cargo.toString());
                System.out.println("Ship"+shipID+" Cargo list.size AFTER" + list.size());
                operationResult = OperationStatus.GOOD;
            } else {
                operationResult = OperationStatus.NO_CARGO_TO_TAKE_FROM_SHIP;
            }
        } else {
            operationResult = OperationStatus.SHIP_IS_EMPTY;
        }
        return new CargoWrapper(cargo, operationResult);
    }

    private int findCargoAtShip() {
        Cargo cargo;
        EnumSet communicationPort = EnumSet.of(PortName.MURMANSK, PortName.KLAIPEDA, PortName.LONDON, PortName.VLADIVOSTOK);
        int size = list.size();
        System.out.println("Trying Find cargo at ship");
        for (int i = 0; i < size; i++) {
            cargo = list.get(i);
            if (communicationPort.contains(cargo.getDestinationPortName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean isReadyAddCargoToShip() {
        return list.size() < getMaxCapacity();
    }

    public void addCargoToShip(Cargo cargo) {
        System.out.println("Loading ship" + shipID);
        list.add(cargo);
        System.out.println("Ship Cargo list.size AFTER" + list.size());
    }

    public void leavePort() {
        System.out.println("Ship " + shipID + " leaves PORT");
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    public int getShipID() {
        return shipID;
    }
    public boolean hasFreeQuote() {
        return operationQuote > 0;
    }

    public void discountOperationQuote() {
        --operationQuote;
    }

    public int getOperationQuote() {
        return operationQuote;
    }
}
