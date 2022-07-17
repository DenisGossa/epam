package by.epam.training.observer;

import java.util.ArrayList;
import java.util.List;
//import java.util.*;

import by.epam.training.action.FigureAction;
import by.epam.training.entity.Pyramid;
import by.epam.training.warehouse.*;

public class PyramidObserver implements FigureObserver {
	private List<Pyramid> list = new ArrayList<>();
	public void addObservable(Pyramid pyramid) {
		
		list.add(pyramid);
		
	};
	
	@Override
	public void handleEvent(PyramidEvent pyramidEvent) {
	
		
		Pyramid pyramid = pyramidEvent.getSource();
	
		List<Double> valueSquareVolume = new ArrayList<>();
				
		valueSquareVolume.add( FigureAction.calculateSquare(pyramid));
		valueSquareVolume.add( FigureAction.calculateVolume(pyramid));
		
		Warehouse.warehouseUpdate(pyramid.getiD(), valueSquareVolume);
		
		
	}

	

}
