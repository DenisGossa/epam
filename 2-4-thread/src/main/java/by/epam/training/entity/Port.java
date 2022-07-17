package by.epam.training.entity;

import by.epam.training.type.*;
import org.apache.logging.log4j.*;


import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static final Logger LOGGER = LogManager.getLogger(Port.class);
    private final PortName portName;
    private final int maxStorageContanerCapacity;
    private int dockStationCount;
    private PortDispatcher portDispatcher;

    PortStorage portStorage = PortStorage.getInstance();
    ReentrantLock portStoragelocker = new ReentrantLock();

    public Port(PortName portName, int maxStorageContanerCapacity, int dockStationCount) {
        portDispatcher = new PortDispatcher(portName);
        this.portName = portName;
        this.maxStorageContanerCapacity = maxStorageContanerCapacity;
        this.dockStationCount = dockStationCount;
        portStorage = new PortStorage(maxStorageContanerCapacity);
    }

    public void startWork() throws InterruptedException {
        for (int id = 0; id < dockStationCount; id++) {
            Thread t = new Thread(new DockStation(this, id, portStorage, portStoragelocker));
            LOGGER.log(Level.INFO,"Dock "+id+" start work");
            t.start();
        }
    }
    public int portStorageCapacity() {
        return portStorage.getPortStorageSize();
    }
    public PortName getPortName() {
        return portName;
    }
    public PortDispatcher getPortDispatcher() {
        return portDispatcher;
    }
}
