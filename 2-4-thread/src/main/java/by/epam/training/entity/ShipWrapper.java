package by.epam.training.entity;

public class ShipWrapper {
    private Ship ship;
    private int operationStatus;

    public ShipWrapper(Ship ship, int operationStatus) {
        this.ship = ship;
        this.operationStatus = operationStatus;
    }

    public Ship getShip() {
        return ship;
    }

    public int getOperationStatus() {
        return operationStatus;
    }
}
