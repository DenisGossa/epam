package by.epam.training.entity;

public class CargoWrapper {
    private Cargo cargo;
    private int operationStatus;

    public CargoWrapper(Cargo cargo, int operationStatus) {
        this.cargo = cargo;
        this.operationStatus = operationStatus;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public int getOperationStatus() {
        return operationStatus;
    }
}

