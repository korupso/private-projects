package ch.meccariello.sorting.sorts;

import java.util.Collections;
import java.util.List;

import ch.meccariello.sorting.ressources.Sort;

/**
 * This class is able to sort a list of integers using the quick sort.
 * 
 * @author Joel Meccariello
 * 30.11.2018
 */
public class Quick implements Sort {
	
	/**
	 * This method receives the unsorted array
	 * and gets the length of the unsorted array.
	 * 
	 * @return	Returns the sorted array.
	 */
	public List<Integer> sort(List<Integer> numbers) {
		return quickSort(0, numbers.size() - 1, numbers);
	}

	/**
	 * This method sets the pivot point
	 * and sorts the array bases on this point.
	 * 
	 * @param	lowerIndex		The lower index of this part of the array.
	 * @param	higherIndex		The higher index of this part of the array.
	 */
	private List<Integer> quickSort(int lowerIndex, int higherIndex, List<Integer> numbers) {
		int i = lowerIndex;
		int j = higherIndex;
		while (i <= j) {
			while (numbers.get(i) < numbers.get(lowerIndex+(higherIndex-lowerIndex)/2)) i++;
			while (numbers.get(j) > numbers.get(lowerIndex+(higherIndex-lowerIndex)/2)) j--;
			if (i <= j) Collections.swap(numbers, i++, j--);
		}
		if (lowerIndex < j) quickSort(lowerIndex, j, numbers);
		if (i < higherIndex) quickSort(i, higherIndex, numbers);
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
