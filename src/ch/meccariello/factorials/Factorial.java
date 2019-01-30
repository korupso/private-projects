package ch.meccariello.factorials;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Factorial {
	
	private static ArrayList<BigInteger> factorials = new ArrayList<BigInteger>(Arrays.asList(new BigInteger("1"), new BigInteger("1")));

	public static void main(String[] args) {
		System.out.println(factorial(500));
	}
	
	public static BigInteger factorial(Object x) {
		BigInteger a = new BigInteger(x.toString());
		if (a.compareTo(new BigInteger((factorials.size() - 1) + "")) <= 0) {
			return factorials.get(a.intValue());
		}
		BigInteger result = new BigInteger(factorials.get(factorials.size() - 1) + "");
		for (BigInteger i = new BigInteger(factorials.size() + ""); i.compareTo(a) <= 0; i = i.add(new BigInteger("1"))) {
			
			result = result.multiply(i);
			factorials.add(result);
		}
		return result;
	}
	
}
