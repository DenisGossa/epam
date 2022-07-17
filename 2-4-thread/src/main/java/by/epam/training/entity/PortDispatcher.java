package by.epam.training.entity;

import by.epam.training.action.GeneratorShipID;
import by.epam.training.type.*;
import org.apache.logging.log4j.*;

import java.util.*;

public class PortDispatcher {
    private static final Logger LOGGER = LogManager.getLogger(PortDispatcher.class);
    private final int MAX_PORT_QUEUE = 500;
    private PortName currentName;
    private Queue<Ship> shipQueue;

    public PortDispatcher(PortName currentName) {
        this.currentName = currentName;
        shipQueue = new LinkedList<Ship>();
        CreateQueueShip();
    }

    private void CreateQueueShip() {
        for (int i = 0; i < MAX_PORT_QUEUE; i++) {
            shipQueue.add(new Ship(new GeneratorShipID().createID()));

        }
        LOGGER.log(Level.INFO,"Queue = "+MAX_PORT_QUEUE+" ships");
    }


    public void addShipToQueue(Ship ship) {
        shipQueue.add(ship);
    }

    public ShipWrapper takeShipFromQueue() {
        int operationStatus;

        Ship ship = shipQueue.poll();
        if (ship != null) {
            ship.setCurrentPortName(currentName);// change to order
            operationStatus = OperationStatus.BEGIN_OPERATION;
            System.out.println("Ship Queue Size = " + shipQueue.size());


        } else {
            operationStatus = OperationStatus.NO_SHIP_AT_QUEUE;
        }
        return new ShipWrapper(ship, operationStatus);
    }

    public int getShipQueueSize() {
        return shipQueue.size();
    }
}
