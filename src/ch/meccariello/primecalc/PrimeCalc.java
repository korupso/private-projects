package ch.meccariello.primecalc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class PrimeCalc {

	public static void main(String[] args) {
		
		LinkedList<Integer> primes = new LinkedList<Integer>(Arrays.asList(2));
		int n = 3;
		boolean isPrime = true;
		System.out.print("Enter how many primes you'd like to calculate (Max 976): ");
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int count;
		if ("max".equals(temp.toLowerCase())) {
			count = 976;
		} else {
			count = Integer.parseInt(temp);
		}
		
		sc.close();
		
		if (count > 0) {
			System.out.print(2);
		}
		
		while (primes.size() < count) {
			for (int i = 0; i < Double.valueOf(Math.sqrt(primes.size())).intValue(); i++) {
				if (n % primes.get(i) == 0) {
					isPrime = false;
				}
			}
			if (isPrime) {
				System.out.print(" " + n);
				primes.add(n);
			} else {
				isPrime = true;
			}
			n += 2;
		}
	}
	
}
