package ch.meccariello.ldm.sortieralgorithmen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class is able to sort a list of integers using the bubble sort.
 * 
 * @author Joel Meccariello
 * 20.12.2018
 */
public class BubbleSort {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 94, 75, 63, 41, 89, 75, 60, 91, 46));
		
		System.out.println(numbers);
		sort(numbers);
		System.out.println(numbers);
	}
	
	/**
	 * This method sorts an array of integers.
	 * 
	 * @param numbers The array to sort.
	 */
	private static void sort(List<Integer> numbers) {
		for (int i = 0; i < numbers.size() - 1; i++) for (int j = 0; j < numbers.size() - i - 1; j++) if (numbers.get(j) > numbers.get(j + 1)) Collections.swap(numbers, j, j + 1);
	}
	
}
