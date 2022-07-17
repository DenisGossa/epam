package by.epam.training.creation;

import java.util.ArrayList;

import java.util.List;

import by.epam.training.entity.*;
import by.epam.training.exception.DataFileReaderException;
import by.epam.training.validation.PyramidValidation;

public class PyramidCreator {

	/* Pyramid creation from list of integers objectParameters
	* objectParameters.
	* Provider of objectParameters is class FigureDataParser
	*/
	public Pyramid create(List<Integer> objectParameters) throws DataFileReaderException {
		Pyramid pyramid = new Pyramid();
				
		
		if ( PyramidValidation.validate(objectParameters)) {
			initialize(pyramid, objectParameters);
		};
		return pyramid;
		
	}

	// at 0 index is a height value, at last coordinate of point one by one
	// 
	private void initialize(Pyramid pyramid, List<Integer> objectParameters) {

		List<Point> pointList = new ArrayList<>();

		pyramid.setHeight(objectParameters.get(0));
		int obsize = objectParameters.size();

		for (int i = 1; i < obsize; i = i + 3) {
			Point point = new Point();

			point.setX(objectParameters.get(i));
			point.setY(objectParameters.get(i + 1));
			point.setZ(objectParameters.get(i + 2));

			pointList.add(point);

		}

		pyramid.setPoint(pointList);

	}

}
