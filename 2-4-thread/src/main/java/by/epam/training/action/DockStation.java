package by.epam.training.action;

import static by.epam.training.type.OperationStatus.*;

import by.epam.training.entity.*;
import org.apache.logging.log4j.*;

import java.util.concurrent.locks.ReentrantLock;

public class DockStation implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(DockStation.class);
    Port port;
    private int dockID;
    private Ship ship;

    PortDispatcher portDispatcher;
    PortStorage portStorage;
    ReentrantLock locker;

    public DockStation(Port port, int dockID, PortStorage portStorage, ReentrantLock lock) {
        this.port = port;
        this.dockID = dockID;
        this.portStorage = portStorage;
        locker = lock;
    }

    public void run() {

        portDispatcher = port.getPortDispatcher();
        int operationStatus;
        CargoWrapper cargoWrapper;

        while (portDispatcher.getShipQueueSize() > 0) {
            locker.lock();
            boolean dockIsBusy = true;

            ShipWrapper shipWrapper = portDispatcher.takeShipFromQueue();
            ship = shipWrapper.getShip();
            operationStatus = shipWrapper.getOperationStatus();

            try {
                while (dockIsBusy) {

                    switch (operationStatus) {

                        case BEGIN_OPERATION:

                            if (ship.isReadyAddCargoToShip()) {
                                operationStatus = LOADING_CARGO_FROM_STORAGE_TO_SHIP;
                                break;
                            } else {
                                operationStatus = LOADING_CARGO_FROM_SHIP_TO_STORAGE;
                                break;
                            }
                        case SHIP_IS_FULL:
                            /* do next LOADING_CARGO_FROM_SHIP_TO_STORAGE instructions */
                        case LOADING_CARGO_FROM_SHIP_TO_STORAGE:
                            System.out.println("LOADING_CARGO_FROM_SHIP_TO_STORAGE");
                            if (portStorage.isReadyAddCargoToPortStorage()) {

                                System.out.println("PORT is READY ");
                                cargoWrapper = ship.takeCargofromShip();
                                operationStatus = cargoWrapper.getOperationStatus();

                                if (operationStatus == GOOD) {

                                    portStorage.addCargoToPortStorage(cargoWrapper.getCargo());
                                    System.out.println("Storage size= " + portStorage.getPortStorageSize());
                                    operationStatus = LOADING_CARGO_FROM_SHIP_TO_STORAGE;

                                } else {
                                    operationStatus = LOADING_CARGO_FROM_STORAGE_TO_SHIP;

                                }
                                ship.discountOperationQuote();
                                break;
                            } else {

                                System.out.println("Storage is FULL");
                                operationStatus = STORAGE_IS_FULL;
                                ship.discountOperationQuote();
                                break;
                            }
                        case SHIP_IS_EMPTY:
                            /*do next LOADING_CARGO_FROM_STORAGE_TO_SHIP instructions */
                        case NO_CARGO_TO_TAKE_FROM_SHIP:
                            /* do next LOADING_CARGO_FROM_STORAGE_TO_SHIP instructions*/
                        case LOADING_CARGO_FROM_STORAGE_TO_SHIP:
                            if (ship.isReadyAddCargoToShip()) {

                                cargoWrapper = portStorage.takeCargoFromPortStorage(port.getPortName());
                                operationStatus = cargoWrapper.getOperationStatus();

                                if (operationStatus == GOOD) {
                                    operationStatus = LOADING_CARGO_FROM_STORAGE_TO_SHIP;
                                    ship.addCargoToShip(cargoWrapper.getCargo());
                                } else {
                                    operationStatus = ALL_IS_WAITING;
                                }
                                ship.discountOperationQuote();
                                break;

                            } else {
                                ship.discountOperationQuote();
                                operationStatus = ALL_IS_WAITING;
                                break;
                            }

                        case NO_CARGO_TO_TAKE_FROM_STORAGE: /*do next ALL_IS_WAITING instructions */

                        case STORAGE_IS_EMPTY: /*do next ALL_IS_WAITING instructions */

                        case STORAGE_IS_FULL: /*do next ALL_IS_WAITING instructions */

                        case ALL_IS_WAITING:
                            if (ship.hasFreeQuote()) {
                                operationStatus = BEGIN_OPERATION;
                                break;
                            } else {
                                operationStatus = ENDING_SHIP_OPERATION;
                                break;
                            }
                        case ENDING_SHIP_OPERATION:
                            ship.leavePort();
                            dockIsBusy = false;

                        case GOOD:
                            operationStatus = BEGIN_OPERATION;
                            break;

                        case NO_SHIP_AT_QUEUE:
                            System.out.println("End Working DockStation");
                            dockIsBusy = false;
                            break;
                        default:
                    }
                }
            } finally {
                locker.unlock();
            }
        }
        LOGGER.log(Level.INFO, "At queue:" + portDispatcher.getShipQueueSize() + " ships");
        LOGGER.log(Level.INFO, "Total PortStorage loading:" + portStorage.getPortStorageSize() + " cargo");
        LOGGER.log(Level.INFO, "Dock " + dockID + " Finished work");
    }
}
