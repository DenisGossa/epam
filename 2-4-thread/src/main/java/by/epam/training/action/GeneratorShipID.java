package by.epam.training.action;

public class GeneratorShipID {
    private static int numID = 0;

    public int createID() {
        return ++numID;
    }
}
