package by.epam.training.observer;

import java.util.EventObject;
import by.epam.training.entity.Pyramid;

public class PyramidEvent extends EventObject {

	/**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public PyramidEvent(Pyramid source) {
        super(source);
    }

	@Override
	public Pyramid getSource() {
		return (Pyramid) super.getSource();
	}

}
