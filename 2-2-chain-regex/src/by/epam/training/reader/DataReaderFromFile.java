package by.epam.training.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.entity.Paragraph;
import by.epam.training.exception.DataFileReaderException;

public class DataReaderFromFile {
	private static final Logger LOGGER = LogManager.getLogger(DataReaderFromFile.class);
	
	private final static String PATH = "./resources/TextForParse.txt";
	private static Path path = Paths.get(PATH);

	public static String loadData() throws IOException {
		LOGGER.log(Level.INFO,"Loading from file");
		return Files.readString(path, StandardCharsets.UTF_16);
	}

}
