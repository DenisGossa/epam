package by.epam.training.entity;

import java.util.*;

public class Journal extends Paper {
    private int subscriptionIndex;
    private String tittle;
    private boolean gloss;

    public int getSubscriptionIndex() {
        return subscriptionIndex;
    }

    public void setSubscriptionIndex(int subscriptionIndex) {
        this.subscriptionIndex = subscriptionIndex;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public boolean isGloss() {
        return gloss;
    }

    public void setGloss(boolean gloss) {
        this.gloss = gloss;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
			}
        if (obj == null || obj.getClass() != this.getClass()) {
        	return false;
   	} 
        Journal journal = (Journal) obj;

        return getSubscriptionIndex() == journal.getSubscriptionIndex() &&
                isGloss() == journal.isGloss() &&
                Objects.equals(getTittle(), journal.getTittle()) &&
                isMothly() == journal.isMothly() &&
                isColor() == journal.isColor() &&
                getVolume() == journal.getVolume() &&
                Objects.equals(getID(), journal.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubscriptionIndex(), getTittle(), isGloss(), isMothly(), isColor(), getVolume(), getID());
    }

    @Override
    public String toString() {
        
	StringBuilder result = new StringBuilder();
		result.append("Journal ");
		result.append(" subscriptionIndex=");
		result.append(subscriptionIndex);
		result.append(" tittle=");
		result.append(tittle);
		result.append(" gloss=");
		result.append(gloss);
		result.append(" monthly=");
		result.append(isMonthly());
		result.append(" color=");
		result.append(isColor());
		result.append(" volume=");
		result.append(getVolume());
		result.append(" id=");
		result.append(getID());

		return result.toString();
   }
}
