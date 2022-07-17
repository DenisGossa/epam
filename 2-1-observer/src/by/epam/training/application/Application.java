package by.epam.training.application;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import by.epam.training.action.FigureAction;
import by.epam.training.creation.PyramidCreator;
import by.epam.training.entity.*;
import by.epam.training.exception.DataFileReaderException;
import by.epam.training.observer.PyramidObserver;
import by.epam.training.parsing.FigureDataParser;
import by.epam.training.reader.LoadFigureDataFromFile;
import by.epam.training.repository.SearchByFigureSpecification;
import by.epam.training.repository.impl.PyramidRepositoryImpl;
import by.epam.training.validation.*;
import by.epam.training.warehouse.Warehouse;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;

public class Application {

	public static void main(String[] args) throws DataFileReaderException {
		// final Logger Logger = LogManager.getLogger();

		Pyramid pyramid;
		PyramidRepositoryImpl repository = new PyramidRepositoryImpl();

		
		
		// LOAD
		LoadFigureDataFromFile loadFigureData = new LoadFigureDataFromFile();
		List<String> list = loadFigureData.load();
		

		// VALIDATION
		if (!list.isEmpty()) {
			FileDataValidation fileDataValidation = new FileDataValidation();

			list = fileDataValidation.validate(list);

			FigureDataParser fdataParser = new FigureDataParser();
			List<Integer> objectParameters = new ArrayList<Integer>();

			
			// PARSING
			for (String s : list) {

				
				objectParameters = fdataParser.parseValues(s);

				// CREATION OBJECT - INITIALISATION
				PyramidCreator pcreator = new PyramidCreator();

				if (!PyramidValidation.validate(objectParameters)) {
					// logger.log(level.WARN, "Can't create pyramid: Invalid ObjectParameters " +
					// s);

					continue;

				}
				
				pyramid = pcreator.create(objectParameters);

				pyramid.addObserver(new PyramidObserver());

			
				
			//	long currentFigureID = pyramid.getiD();
				List<Double> valueSquareVolume = new ArrayList<>();

				double square = FigureAction.calculateSquare(pyramid);
						valueSquareVolume.add(square);

						double volume = FigureAction.calculateVolume(pyramid);
						valueSquareVolume.add(volume);
				Warehouse.addToWarehouse(pyramid.getiD(), valueSquareVolume);

				System.out.println("Before Parse:" + s);
					
				System.out.println("Volume:" + volume);
				System.out.println("Squre:" + square);
				
				
				// Adding figure to Repository

				repository.add(pyramid);
				
			//	pyramid.changePointValue(50);

			}

			
			SearchByFigureSpecification sp = new SearchByFigureSpecification();
		//	sp.setMinId(5000);
			 List<Pyramid> tmpList = repository.query(sp.MORE_THEN_MIN_ID);
			
		//	 System.out.println("Find by min Id " + tmpList.toString() );
			
			
		//	System.out.println(": " + );
		//	System.out.println("At repository: " + repository.query(sp.setMinId(4000)));
			System.out.println("Warehouse Keys " + Warehouse.getKeys());

		//	System.out.println(Warehouse.getMap());

		}
	}

}
