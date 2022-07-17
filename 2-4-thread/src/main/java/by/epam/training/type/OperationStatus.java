package by.epam.training.type;

public final class OperationStatus {
    public final static int GOOD = 0;
    public final static int STORAGE_IS_EMPTY = -1;
    public final static int STORAGE_IS_FULL = -2;
    public final static int SHIP_IS_EMPTY = -3;
    public final static int SHIP_IS_FULL = -4;
    public final static int NO_CARGO_TO_TAKE_FROM_SHIP = -5;
    public final static int NO_CARGO_TO_TAKE_FROM_STORAGE = -6;
    public final static int NO_SHIP_AT_QUEUE = -7;
    public final static int BEGIN_OPERATION= -8;
    public final static int END_OF_WORK_SHIFT = -9;
    public final static int SHIP_IS_WAITING_LOADING=-10;
    public final static int STORAGE_IS_WAITING_LOADING=-11;
    public final static int SHIP_IS_WAITING_UNLOADING=-12;
    public final static int STORAGE_IS_WAITING_UNLOADING=-13;
    public final static int LOADING_CARGO_FROM_STORAGE_TO_SHIP=-14;
    public final static int LOADING_CARGO_FROM_SHIP_TO_STORAGE=-15;
    public final static int ALL_IS_WAITING=-16;
    public final static int ENDING_SHIP_OPERATION=-17;
}
