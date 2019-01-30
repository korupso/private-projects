package ch.meccariello.sorting.sorts;

import java.util.List;

import ch.meccariello.sorting.ressources.Sort;

/**
 * This class is able to sort a list of integers using the insertion sort.
 * 
 * @author Joel Meccariello
 * 06.12.2018
 */
public class Insertion implements Sort {
	
	/**
	 * This method sorts an array of integers.
	 * 
	 * @return Returns the sorted array.
	 */
	public List<Integer> sort(List<Integer> numbers) {
		
		int temp;
		for (int i = 1; i < numbers.size(); i++) {
			temp = numbers.get(i);
			int j = i;
			while (j > 0 && numbers.get(j - 1) > temp) {
				numbers.set(j, numbers.get(j - 1));
				j--;
			}
			numbers.set(j, temp);
		}
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
