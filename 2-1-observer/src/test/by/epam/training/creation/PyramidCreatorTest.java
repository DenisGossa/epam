package test.by.epam.training.creation;

import java.util.*;

import org.testng.Assert;

import by.epam.training.creation.PyramidCreator;
import by.epam.training.entity.*;
import by.epam.training.exception.DataFileReaderException;

public class PyramidCreatorTest {

	PyramidCreator pyramidCreator;
	List<Integer> objectParameters = Arrays.asList(15, 2, 2, 0, 10, 2, 0, 2, -6, 0, 10, -6, 0);


	void create() throws DataFileReaderException {
		// given

		Pyramid actual = new Pyramid(0L, new Point(2, 2, 0),
						new Point(10, 2, 0), new Point(2, -6, 0),
						new Point(10, -6, 0));
		actual.setHeight(15);
		// when
		pyramidCreator = new PyramidCreator();

		Pyramid expected = pyramidCreator.create(objectParameters);

		// then
		Assert.assertEquals(actual, expected);
	}

}
