package by.epam.training.entity;

import by.epam.training.exception.*;

public abstract class Paper {
    
    private boolean mothly;
    private boolean color;
    private int volume;
    private String id;

    public boolean isMothly() {
        return mothly;
    }

    public void setMothly(boolean mothly) {
        this.mothly = mothly;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public abstract int getSubscriptionIndex() throws MethodNotSupportedException;
    public abstract void setSubscriptionIndex(int subscriptionIndex) throws MethodNotSupportedException;
    public abstract String getTittle();
    public abstract void setTittle(String tittle);
    public abstract boolean isGloss() throws MethodNotSupportedException;
    public abstract void setGloss(boolean gloss) throws MethodNotSupportedException;
}
