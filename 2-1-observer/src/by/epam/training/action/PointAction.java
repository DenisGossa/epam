package by.epam.training.action;

import java.util.*;

import by.epam.training.entity.Point;

public class PointAction {

	private static List<Point> pointList = new ArrayList<>();

	/*
	 * Check is the array of Integer point a square. At the List of Integer are
	 * coordinates [x1 y1 z1 x2 y2 z2 x3 y3 z3 x4 y4 z4] "Z-coord always must be
	 * zero
	 */
	public static boolean isPolygonSquare(List<Integer> polygonPointCoordinates) {

		Point point1, point2, point3, point4;

		final int POINT_1 = 0;
		final int POINT_2 = 1;
		final int POINT_3 = 2;
		final int POINT_4 = 3;

		if (polygonPointCoordinates.isEmpty()) {
			return false;
		}
		
		pointList.clear();
		int listSize = polygonPointCoordinates.size();

		for (int i = 0; i < listSize; i = i + 3) {
			Point tmppoint = new Point();

			tmppoint.setX(polygonPointCoordinates.get(i));
			tmppoint.setY(polygonPointCoordinates.get(i + 1));

			// z coord must be ZERO
			int zCoord = polygonPointCoordinates.get(i + 2);
			if (zCoord == 0) {
				tmppoint.setZ(zCoord);
			} else {
				return false;
			}

			pointList.add(tmppoint);

		}
		// take from list 4 points
		point1 = pointList.get(POINT_1);
		point2 = pointList.get(POINT_2);
		point3 = pointList.get(POINT_3);
		point4 = pointList.get(POINT_4);

		// List of distance between all points
		List<Double> distance = new ArrayList<>();

		distance.add(distance(point1, point2));
		distance.add(distance(point1, point3));
		distance.add(distance(point1, point4));
		distance.add(distance(point2, point3));
		distance.add(distance(point2, point4));
		distance.add(distance(point3, point4));
		Collections.sort(distance);

		// lets get 4 sides and 2 diagonals
		double side1, side2, side3, side4, diagonal1, diagonal2;
		side1 = distance.get(0);
		side2 = distance.get(1);
		side3 = distance.get(2);
		side4 = distance.get(3);
		diagonal1 = distance.get(4);
		diagonal2 = distance.get(5);

		System.out.println("distance:" + distance.toString());

		// if 4 side are equals and 2 diagonal are equals - this is a square
		return isEqual(side1, side2) & isEqual(side2, side3) & isEqual(side3, side4) & isEqual(diagonal1, diagonal2);

	}

	// finding distance between two points
	// Pifagor forever!
	private static double distance(Point p1, Point p2) {

		double deltaX, deltaY;

		deltaX = Math.abs(p1.getX() - p2.getX());
		deltaY = Math.abs(p1.getY() - p2.getY());

		return Math.sqrt(Math.pow(deltaX, 2) + (Math.pow(deltaY, 2)));

	}

	private static boolean isEqual(double a, double b) {
		final double EPSILON = 0.0000000000000001;
		return Math.abs(a / b - 1) < EPSILON;

	}
}
