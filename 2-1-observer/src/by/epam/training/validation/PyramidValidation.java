package by.epam.training.validation;

import java.util.*;

import by.epam.training.action.PointAction;
import by.epam.training.entity.Point;

public class PyramidValidation {

	private static List<Integer> polygonPointCoordinates;
	private final static int INDEXHEIGHTVALUE = 0;
	private final static int MINHEIGHTVALUE = 1;

	public static boolean validate(List<Integer> objectParameters) {
		
		/* first value - height
		* and 4 point with 3 coordinates x,y,z
		 all 13 values must be in objectParameters*/
		final int initializationPointCount = 13;
		
		if (objectParameters== null|| objectParameters.isEmpty() 
				|| objectParameters.size() != initializationPointCount) {
			return false;
		}

		if (objectParameters.get(INDEXHEIGHTVALUE) < MINHEIGHTVALUE) {
			return false;
		}

		polygonPointCoordinates = new ArrayList<Integer>(objectParameters);
		polygonPointCoordinates.remove(INDEXHEIGHTVALUE);

		if (PointAction.isPolygonSquare(polygonPointCoordinates)) {
			return true;
		}
		
		return false;
	}

}
