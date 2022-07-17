package by.epam.training.entity;

import java.util.ArrayList;

import java.util.List;
import by.epam.training.observer.*;

public class Pyramid extends Figure {

	private int height;
	private List<Point> pointList;
	private long iD;

	public Pyramid() {
		this.iD = Pyramid.createID();
	}

	public Pyramid(long iD, Point point1, Point point2, Point point3, Point point4) {
	    this.iD = iD;
	    pointList.set(0, point1);
	    pointList.set(1, point2);
	    pointList.set(2, point3);
	    pointList.set(3, point4);

	  }
	
	private PyramidObserver observer;

	public void addObserver(PyramidObserver observer) {
		this.observer = observer;
		observer.addObservable(this);

	};

	public long getiD() {
		return iD;
	}

	@Override
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public List<Point> getPointList() {
		return pointList;
	}

	public void setPoint(List<Point> point) {
		this.pointList = point;
	}

	public void changePointValue(List<Point> point) {
		setPoint(point);
		notifyObservers();

	}

	public void changePointValue(int height) {
		setHeight(height);
		notifyObservers();

	}

	private void notifyObservers() {
		if (observer != null) {
			observer.handleEvent(new PyramidEvent(this));

		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((pointList == null) ? 0 : pointList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Pyramid other = (Pyramid) obj;
		return  iD==other.iD& height == other.height
				&pointList.equals(other.pointList);
 	}

	@Override
	public String toString() {
		return "Pyramid [pointList=" + pointList + "]";
	}

}
