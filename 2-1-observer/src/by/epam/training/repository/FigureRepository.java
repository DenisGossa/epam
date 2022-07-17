package by.epam.training.repository;

import java.util.Comparator;

import java.util.List;

import by.epam.training.entity.*;

public interface FigureRepository {

	void add(Pyramid pyramid);
	void remove(Pyramid pyramid);
	Figure getFigure(int index);
	List<Pyramid> getAllPyramides();
	List query(FigureSpecification specification);
	List<Figure> sortFigure(Comparator<Figure> comparator);
	int size();
	
	
}
