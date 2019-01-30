package ch.meccariello.sorting.sorts;

import java.util.ArrayList;
import java.util.List;

import ch.meccariello.sorting.ressources.Sort;

/**
 * This class is able to sort a list of integers using the merge sort. 
 * 
 * @author Joel Meccariello
 * 06.12.2018
 */
public class Merge implements Sort {
  
	public List<Integer> sort(List<Integer> numbers) {
		sortSmall(numbers, 0, numbers.size() - 1);
		return numbers;
	}
	
	private void sortSmall(List<Integer> numbers, int l, int r) { 
		if (l < r) { 
			int m = (l + r) / 2; 
			sortSmall(numbers, l, m); 
			sortSmall(numbers , m + 1, r); 
			merge(numbers, l, m, r); 
		} 
	} 
	
	private void merge(List<Integer> numbers, int l, int m, int r) {
		ArrayList<Integer> left = new ArrayList<Integer>() {{
			for (int i = 0; i < m - l + 1; i++) add(null);
		}};
		ArrayList<Integer> right = new ArrayList<Integer>() {{
			for (int i = 0; i < r - m; i++) add(null);
		}};
		for (int i = 0; i < m - l + 1; ++i) left.set(i, numbers.get(l + i)); 
		for (int j = 0; j < r - m; ++j) right.set(j, numbers.get(m + 1+ j));
		int i = 0, j = 0, k = l;
		while (i < m - l + 1 && j < r - m) numbers.set(k++, (left.get(i) <= right.get(j)) ? left.get(i++) : right.get(j++));
		while (i < m - l + 1) numbers.set(k++, left.get(i++));
		while (j < r - m) numbers.set(k++, right.get(j++));
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
