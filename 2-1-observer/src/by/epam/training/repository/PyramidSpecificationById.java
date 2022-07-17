package by.epam.training.repository;

import by.epam.training.entity.Pyramid;

public class PyramidSpecificationById implements FigureSpecification {

	private long minValue;
	private long maxValue;

	public PyramidSpecificationById(long minValue, long maxValue) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public boolean specified(Pyramid pyramid) {
		// return pyramid.ageBetween(minAge, maxAge);

		return false;
	}

}
