package by.epam.training.type;

import java.util.Random;

public enum PortName {
    KLAIPEDA,
    LONDON,
    MURMANSK,
    NEWYORK,
    STAMBUL,
    VLADIVOSTOK;

    public static PortName getRandomPortName() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
    }
