package by.epam.training.entity;

import java.util.List;

public abstract class Figure {
	
	private static long iD;

	public static synchronized long createID() {
		
		iD = iD/2 + 3141 ;
		return iD;
	}
	public abstract long getiD();
	public abstract int getHeight();
	public abstract List<Point> getPointList();

}
