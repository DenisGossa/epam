package by.epam.training.validation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidation {

	public static boolean validateFile(Path path) {
		try {
			if (Files.exists(path) && !Files.isDirectory(path) && (Files.size(path)!=0)) {
				return true;

			}
		} catch (IOException e) {
			
			e.printStackTrace();
			// logger.log(log.fatal,"FATAL ERROR with file");
		}

		return false;
	}

}
