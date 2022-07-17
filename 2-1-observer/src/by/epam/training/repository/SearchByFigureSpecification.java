package by.epam.training.repository;

import by.epam.training.action.FigureAction;

public class SearchByFigureSpecification {

	private long minId, maxId;
	private double minSquare, minVolume;
	final int point1 = 0;
	final int point2 = 1;
	final int point3 = 2;
	final int point4 = 3;

	public final FigureSpecification MORE_THEN_MIN_ID = t -> t.getiD() >= minId;

	public final FigureSpecification LESS_THEN_MAX_ID = t -> t.getiD() <= maxId;

	public final FigureSpecification MORE_THEN_MIN_SQUARE = t -> FigureAction.calculateVolume(t) >= minSquare;

	public final FigureSpecification MORE_THEN_MIN_VOLUME = t -> FigureAction.calculateSquare(t) >= minVolume;

	public final FigureSpecification IN_THE_FIRST_QUADRANT = t -> {
		    return
		                  t.getPointList().get(point1).getX() >= 0 &&
		                  t.getPointList().get(point1).getY() >= 0 &&
		                  t.getPointList().get(point1).getZ() >= 0 &&

		                   t.getPointList().get(point2).getX() >= 0 &&
				           t.getPointList().get(point2).getY() >= 0 &&
				           t.getPointList().get(point2).getZ() >= 0 &&

				           t.getPointList().get(point3).getX() >= 0 &&
						   t.getPointList().get(point3).getY() >= 0 &&
						   t.getPointList().get(point3).getZ() >= 0 &&
						                
						   t.getPointList().get(point4).getX() >= 0 &&
						   t.getPointList().get(point4).getY() >= 0 &&
						   t.getPointList().get(point4).getZ() >= 0 ;
		  };

	public void setMinId(long minId) {
		this.minId = minId;
	}

	public void setMaxId(long maxId) {
		this.maxId = maxId;
	}

	public void setMinSquare(double minSquare) {
		this.minSquare = minSquare;
	}

	public void setMinVolume(double minVolume) {
		this.minVolume = minVolume;
	}

	

}
