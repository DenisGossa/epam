package by.epam.training.runner;

import by.epam.training.entity.*;
import by.epam.training.type.PortName;
import org.apache.logging.log4j.*;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    public static void main(String[] args) {

        LOGGER.log(Level.INFO,"Port Creating");
        Port port = new Port(PortName.MURMANSK, 20000, 5);

        try {
            port.startWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
