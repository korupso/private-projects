package ch.meccariello.sorting.sorts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ch.meccariello.sorting.ressources.Sort;

/**
 * This class is able to sort a list of integers using the radix sort.
 * 
 * @author Joel Meccariello
 * 30.11.2018
 */
public class Radix implements Sort {

	public List<Integer> sort(List<Integer> numbers) {
		
		ArrayList<Queue<Integer>> buckets = new ArrayList<Queue<Integer>>() {{	// Initialize an array list where the partially sorted numbers go
			for (int i = 0; i < 10; i++)										// Loop 10 times
				add(new LinkedList<Integer>());									// Add an empty linked list
		}};																		// Close inner class
		boolean sorted = false;													// Initialize boolean for later checking
	    int exponent = 1;														// Initialize exponent at 1
	    
	    while (!sorted) {														// Loop until sorted
	    	sorted = true;														// Set sorted to true
	        int i = 0;															// Set i to 0
	        
	        for (int number : numbers) {										// Loop through every number in unsorted list
	            Integer bucket = (number / exponent) % 10;							// Set bucket to (number / exponent) % 10
	            if (bucket > 0) sorted = false;									// Check if the list is sorted
	            buckets.get(bucket).add(number);								// Add the numbers to their corresponding buckets
	        }

	        exponent *= 10;														// Multiply the exponent times 10

	        for (Queue<Integer> bucket : buckets)								// Loop through every bucket
	        	while (!bucket.isEmpty())										// Loop until bucket is empty
	        		numbers.set(i++, bucket.remove());							// Remove every number from the buckets
	    }
		
		return numbers;															// Return the sorted list
	}
	
	public Object sort(List<Integer> numbers, boolean verbose) {
		return new Object[] {"Done", sort(numbers)}[verbose ? 1 : 0];
	}
	
}
