package by.epam.training.comparator;

import java.util.Comparator;
import by.epam.training.entity.Pyramid;

public class PiramidComparator {

	private static final int INDEX = 0;
	public final static Comparator<Pyramid> PyramidIdComparator = Comparator.comparing(Pyramid::getiD);

	/*
	 * for realization sort Pyramids by coordinate of the first point at list of
	 * Points need use INDEX = 0;
	 */
	public final static Comparator<Pyramid> PyramidFirstXComparator = Comparator
			.comparing(t -> t.getPointList().get(INDEX).getX());

	public final static Comparator<Pyramid> PyramidFirstYComparator = Comparator
			.comparing(t -> t.getPointList().get(INDEX).getY());

	public final static Comparator<Pyramid> TetrahedronFirstZComparator = Comparator
			.comparing(t -> t.getPointList().get(INDEX).getZ());

}
