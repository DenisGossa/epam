package by.epam.training.action;

import java.util.List;


import by.epam.training.entity.*;
public class FigureAction {

////////////////////////////////////////////////////////////
	public static double calculateVolume(Figure figure) {

		return Math.pow(findSide(figure), 2) * figure.getHeight() / 3;

	}

////////////////////////////////////////////////////////////	
	public static double calculateSquare(Figure figure) {

		if (figure == null) {

			// logger.log(logg.error, "ERROR reading figure data");

			return 0;

		}

		int side = findSide(figure);
		double apofema = findApofema(figure);

		return 2 * side * apofema + Math.pow(side, 2);

	}

////////////////////////////////////////////////////////////
	private static double findApofema(Figure figure) {

		return Math.sqrt(Math.pow(findSide(figure) / 2, 2) + Math.pow(figure.getHeight(), 2));

	}

////////////////////////////////////////////////////////////
	private static int findSide(Figure figure) {

		final int PYRAMIDPOINT = 4;
		final int POINT_1 = 0;
		final int POINT_2 = 1;
		final int POINT_3 = 2;
		final int POINT_4 = 3;

		Point point1, point2, point3, point4;

		List<Point> pointList = figure.getPointList();

		if (pointList.size() == PYRAMIDPOINT) {

			point1 = pointList.get(POINT_1);
			point2 = pointList.get(POINT_2);
			point3 = pointList.get(POINT_3);
			point4 = pointList.get(POINT_4);

			int x1 = point1.getX();

			int x2 = point2.getX();

			if (x1 == x2) {
				return Math.abs(point1.getY() - point2.getY());

			} else {
				int x3 = point3.getX();

				if (x1 == x3) {
					return Math.abs(point1.getY() - point3.getY());

				} else {
					return Math.abs(point1.getY() - point4.getY());

				}
			}
		}

		return 0;
	}

}
