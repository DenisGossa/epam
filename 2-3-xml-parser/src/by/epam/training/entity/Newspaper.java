package by.epam.training.entity;

import java.util.*;

public class Newspaper extends Paper {
   
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
        Newspaper newspaper = (Newspaper) obj;
        return getSubscriptionIndex() == newspaper.getSubscriptionIndex() &&
                isGloss() == newspaper.isGloss() &&
                Objects.equals(getTittle(), newspaper.getTittle()) &&
                isMothly() == newspaper.isMothly() &&
                isColor() == newspaper.isColor() &&
                getVolume() == newspaper.getVolume() &&
                Objects.equals(getId(), newspaper.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubscriptionIndex(), getTittle(), isGloss(), isMothly(), isColor(), getVolume(), getID());
    }

    @Override
    public String toString() {
       
		StringBuilder result = new StringBuilder();

		result.append("Newspaper ");
		result.append(" subscriptionIndex=");
		result.append(subscriptionIndex);
		result.append(" tittle=");
		result.append(tittle);
		result.append(" gloss=");
		result.append(gloss);
		result.append(" monthly=");
		result.append(monthly);
		result.append(" volume=");
		result.append(volume);
		result.append(" id=");
		result.append(getID());

		return result.toString();
    }
}
