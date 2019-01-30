package ch.meccariello.ldm.sortieralgorithmen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(29, 70, 26, 12, 45, 2, 85, 52, 85, 92));
		
		System.out.println(numbers);
		sort(numbers);
	}
	
	private static void sort(List<Integer> numbers) {
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
	}
	
}
