package by.epam.training.entity;

import by.epam.training.runner.Runner;
import by.epam.training.type.*;
import org.apache.logging.log4j.*;

import java.util.*;

public class PortStorage {
    private static final Logger LOGGER = LogManager.getLogger(PortStorage.class);
    private int maxStorageCapacity;
    private List<Cargo> storage;

    PortStorage(int maxStorageCapacity) {
        storage = new LinkedList<Cargo>();
        this.maxStorageCapacity = maxStorageCapacity;

    }

    private volatile static PortStorage instance;

    private PortStorage() {
    }

    public static PortStorage getInstance() {
        if (instance == null) {
            synchronized (PortStorage.class) {
                if (instance == null) {
                    instance = new PortStorage();
                    System.out.println("Create dispatcher");
                    LOGGER.log(Level.INFO,"Create dispatcher");
                }
            }
        }
        return instance;
    }


    public boolean addCargoToPortStorage(Cargo cargo) {

        if (storage.size() < maxStorageCapacity) {
            storage.add(cargo);
            return true;
        }
        return false;
    }

    public CargoWrapper takeCargoFromPortStorage(PortName currentPortName) {
        Cargo cargo = null;
        int opeartionStatus;

        if (storage.size() > 0) {
            int indexResult = findCargo(currentPortName);
            if (indexResult >= 0) {
                cargo = storage.remove(indexResult);
                opeartionStatus = OperationStatus.GOOD;
            } else {
                opeartionStatus = OperationStatus.NO_CARGO_TO_TAKE_FROM_STORAGE;
            }

        } else {
            opeartionStatus = OperationStatus.STORAGE_IS_EMPTY;
        }
        return new CargoWrapper(cargo, opeartionStatus);
    }

    private int findCargo(PortName currentPortName) {
        Cargo cargo;
        EnumSet communicationPort=EnumSet.of(PortName.KLAIPEDA,PortName.LONDON,
                PortName.VLADIVOSTOK, PortName.STAMBUL,PortName.NEWYORK);
        int size = storage.size();
        for (int i = 0; i < size; i++) {
            cargo = storage.get(i);

            if (communicationPort.contains(cargo.getDestinationPortName())) {

                return i;
            }
        }
        return -1;
    }

    public int getPortStorageSize() {
        return storage.size();
    }

    public boolean isReadyAddCargoToPortStorage() {
        return storage.size() < maxStorageCapacity;
    }

}
