package by.epam.training.entity;

import by.epam.training.exception.*;

import java.util.*;

public class Booklet extends Paper {
   
    private String tittle;
    private boolean gloss;

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
    public int getSubscriptionIndex() throws MethodNotSupportedException {
        throw new MethodNotSupportedException("NotSupported");
    }

    @Override
    public void setSubscriptionIndex(int subscriptionIndex) throws MethodNotSupportedException {
        throw new MethodNotSupportedException("NotSupported");
    }

    @Override
    public boolean equals(Object obj) {
         if (this == obj) {
			return true;
			}
        if (obj == null || obj.getClass() != this.getClass()) {
        	return false;
   	} 

        return  isGloss() == booklet.isGloss() &&
                Objects.equals(getTittle(), booklet.getTittle()) &&
                isMothly() == booklet.isMothly() &&
                isColor() == booklet.isColor() &&
                getVolume() == booklet.getVolume() &&
                Objects.equals(getID(), booklet.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTittle(), isGloss(), isMothly(), isColor(), getVolume(), getID());
    }

    @Override
    public String toString() {
        
	StringBuilder result = new StringBuilder();
		result.append("Booklet ");
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
