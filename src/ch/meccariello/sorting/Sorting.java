package ch.meccariello.sorting;

import java.lang.reflect.InvocationTargetException;

import ch.meccariello.sorting.ressources.Benchmark;
import ch.meccariello.sorting.sorts.*;

/**
 * This class is used to test and display the sorting of the algorithms.
 * 
 * @author Joel Meccariello
 * 30.11.2018
 */
public class Sorting {

	public static void main(String[] args) {
		
		try {
			
			Benchmark.run(
				// The size of the array lists and the highest number
				new int[]{10, 10},
				
				// The algorithms to benchmark
				new Class<?>[] {Quick.class, Radix.class, Merge.class, Selection.class, Insertion.class, Bubble.class}
			);
			
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
			ex.printStackTrace();
		}
		
	}
	
}
