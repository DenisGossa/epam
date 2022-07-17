package by.epam.training.reader;

import java.io.*;



import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.apache.logging.log4j.*;

import by.epam.training.exception.*;
import by.epam.training.validation.FileValidation;

public class LoadFigureDataFromFile {

	// private static final Logger LOGGER =
	// LogManager.getLogger(LoadFigureDataFromFile.class );

	private final String PATH = "./resources/FigureDataFile.txt";
	private Path path = Paths.get(PATH);
	public List<String> loadedDataList = new ArrayList<>();

	/*
	 * Loading data from file
	 */
	public List<String> load() throws DataFileReaderException {

		if (FileValidation.validateFile(path)) {

			try {
				Stream<String> linesStream = Files.lines(path);
				loadedDataList = linesStream.collect(Collectors.toList());

			} catch (IOException ignored) {
			}

		} else

		{
			// log.error("Incorrect file" + file);
			throw new DataFileReaderException("Incorrect file: " + path.toString());

		}
		return loadedDataList;
	}

	
	
	
}
