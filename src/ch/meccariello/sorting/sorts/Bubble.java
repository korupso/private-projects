package ch.meccariello.sorting.sorts;

import java.util.Collections;
import java.util.List;

import ch.meccariello.sorting.ressources.Sort;

/**
 * This class is able to sort a list of integers using the bubble sort.
 * 
 * @author Joel Meccariello
 * 30.11.2018
 */
public class Bubble implements Sort {
	
	/**
	 * This method sorts an array of integers.
	 * 
	 * @param  numbers The array to sort.
	 * @return Returns the sorted array.
	 */
	public List<Integer> sort(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) for (int j = 0; j < numbers.size() - i - 1; j++) if (numbers.get(j) > numbers.get(j + 1)) Collections.swap(numbers, j, j + 1);
		return numbers;
	}
	
	/**
	 * This method overloads the method {@link sort(List<Integer> numbers)} and checks,
	 * if the developer wants the sorting to be verbose or not.
	 * 
	 * @return	Returns either a string saying "Done", if the output is not verbose,
	 * 			or returns the sorted list, if the output is verbose.
	 */
	public Object sort(List<Integer> numbers, boolean verbose) {
		return new Object[] {"Done", sort(numbers)}[verbose ? 1 : 0];
	}
	
}
