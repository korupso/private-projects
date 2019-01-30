package ch.meccariello.sorting.sorts;

import java.util.Collections;
import java.util.List;

import ch.meccariello.sorting.ressources.Sort;

/**
 * This class is able to sort a list of integers using the selection sort.
 * 
 * @author Joel Meccariello
 * 07.12.2018
 */
public class Selection implements Sort {

	public List<Integer> sort(List<Integer> numbers) {

		for (int i = 0; i < numbers.size() - 1; i++) {
			int n = i;
			for (int j = i + 1; j < numbers.size(); j++) if (numbers.get(j) < numbers.get(n)) n = j;
			Collections.swap(numbers, i, n);
		}
		
		return numbers;

	}

	/**
	 * This method overloads the method {@link sort({@link List}<{@link Integer}>
	 * numbers)} and checks, if the developer wants the sorting to be verbose or
	 * not.
	 * 
	 * @return Returns either a string saying "Done", if the output is not verbose,
	 *         or returns the sorted list, if the output is verbose.
	 */
	public Object sort(List<Integer> numbers, boolean verbose) {
		return new Object[] { "Done", sort(numbers) }[verbose ? 1 : 0];
	}

}
