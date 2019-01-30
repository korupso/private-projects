package ch.meccariello.sorting.ressources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SplittableRandom;

import ch.meccariello.sorting.sorts.Bubble;

public class NumberGenerator {

	private static int n;
	private static int k;
	
	/**
	 * This method creates three {@link Integer} {@link ArrayList}s based on the parameters.<br>
	 * If the parameter would be {100, 1000} the output {@link ArrayList}s would be<br>
	 * filled with 100 integers each. The highest integer being 1000.<br>
	 * The three generated {@link ArrayList}s are the best, average and worst case<br>
	 * for the {@link Bubble} sort.<br>
	 * The best case is an already sorted {@link ArrayList}. The average case is a shuffled<br>
	 * {@link ArrayList}. The worst case is sorted {@link ArrayList}, that's reversed.<br>
	 * 
	 * @param nk	The two parameters. One deciding the length of the generated arrays,<br>
	 * 				the other one deciding the highest possible number in the arrays.<br>
	 * @return		Returns an {@link ArrayList} with three {@link ArrayList}s, that contain<br>
	 * 				the best, average and worst case {@link ArrayList}s for the sorting algorithm<br>
	 * 				{@link Bubble} sort.
	 */
	public static ArrayList<ArrayList<Integer>> start(int[] nk) {
		n = nk[0];
		k = nk[1];
		ArrayList<Integer> bestCase = new ArrayList<Integer>() {{
			new SplittableRandom().ints(n).forEach(i -> add((i < 0 ? -i : i) % k));
		}};
		ArrayList<Integer> averageCase = new ArrayList<Integer>(bestCase);
		Collections.sort(bestCase);
		ArrayList<Integer> worstCase = new ArrayList<Integer>(bestCase);
		Collections.reverse(worstCase);
		

		return new ArrayList<ArrayList<Integer>>() {{
			add(bestCase);
			add(averageCase);
			add(worstCase);
		}};
	}
	
	/**
	 * This method returns true, if the length of the highest number times the length of<br>
	 * the list is less than 2769.
	 * 
	 * @return		Returns a boolean to check, if the output is short enough for the console.
	 */
	public static boolean isNotTooLong() {
		return ((Integer.valueOf(k).toString().length()) * n <= 2769) ? true : false;
	}
	
	/**
	 * This method is here, to check the length of the generated {@link ArrayList}s.
	 * 
	 * @return		Returns the length of the generated {@link ArrayList}s.
	 */
	public static int length() {
		return n;
	}
	
	/**
	 * This method is here, to get the highest number of the {@link ArrayList}s.
	 * 
	 * @return		Returns the highest number of the generated {@link ArrayList}s.
	 */
	public static int top() {
		return k;
	}

}
