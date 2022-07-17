package by.epam.training.repository.impl;

import java.util.*;
import java.util.stream.Collectors;

import by.epam.training.entity.*;
import by.epam.training.repository.*;

public class PyramidRepositoryImpl implements FigureRepository {

	List<Pyramid> pyramidStorage = new ArrayList<Pyramid>();

	@Override
	public void add(Pyramid pyramid) {

		pyramidStorage.add(pyramid);
	}

	@Override
	public List query(FigureSpecification specification) {
		return pyramidStorage.stream().filter(specification::specified).collect(Collectors.toList());
	}

	@Override
	public List<Figure> sortFigure(Comparator<Figure> comparator) {
		List<Figure> tmpList = new ArrayList<>(pyramidStorage);
		tmpList.sort(comparator);
		return tmpList;
	}

	@Override
	public Figure getFigure(int index) {
		return pyramidStorage.get(index);
	}

	@Override
	public List<Pyramid> getAllPyramides() {
		return pyramidStorage;
	}

	@Override
	public void remove(Pyramid pyramid) {
		pyramidStorage.remove(pyramid);

	}

	@Override
	public int size() {
		return pyramidStorage.size();
	}

}