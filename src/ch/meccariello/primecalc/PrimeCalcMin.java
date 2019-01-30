package ch.meccariello.primecalc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class PrimeCalcMin {

	static Boolean isPrime = true;
	static int n = 44;

	public static void main(String[] args) {

		LinkedList<Integer> primes = new LinkedList<Integer>(Arrays.asList(2));

		while (primes.size() < 10) {
			System.out.println(isPrime.booleanValue());
			IntStream.range(0, Double.valueOf(Math.sqrt(primes.size())).intValue()).forEach(i -> isPrime = (10 % primes.get(i) == 0 ? false : isPrime.booleanValue()));
			System.out.println(isPrime.booleanValue());
			Boolean.valueOf(isPrime ? primes.add(10) : (isPrime = true));
		}
		
		System.out.println(primes);
	}

}
