package by.epam.training.warehouse;

import java.util.*;

/**
 * WAREHOUSE CLASS: Contaner- repository for keeping values Square and Volume of
 * each validated Figure(Pyramid) in
 *
 * map<iD, valueSquareVolume> as Key - is iD of Piramid as Value - is
 * List<Double> (two elements:double Square(Pyramid.getSquare()), double Volume(
 * Pyramid.getVolume())
 */

public class Warehouse {

	private static final Warehouse WAREHOUSE;
	private static Map<Long, List<Double>> map;

		
	static {
		WAREHOUSE = new Warehouse();
		// logger.log(log.info,"Storage created.");
	}

	private Warehouse() {

		map = new HashMap<Long, List<Double>>();
	}

	public static Map<Long, List<Double>> getMap() {
		return map;
	}
	public static Warehouse getWarehouse() {
		return WAREHOUSE;
	}

	public static void addToWarehouse(Long iD, List<Double> valueSquareVolume) {

		map.putIfAbsent(iD, valueSquareVolume);

	}

	public static int warehouseSize() {
		return map.size();
	}

	
	public static Set<Long> getKeys() {

		return (Set<Long>) map.keySet();
	}

	public static void warehouseUpdate(Long iD, List<Double> valueSquareVolume) {
		map.replace(iD, valueSquareVolume);
		
		

	}
	 public static void printValues(Map<Long, List<Double>> map)
	    {
		 List<Object> entryList = new ArrayList<Object>(map.entrySet());
		 System.out.println( entryList.toString());
	    }
	
}