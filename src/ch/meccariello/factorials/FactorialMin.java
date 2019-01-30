package ch.meccariello.factorials;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FactorialMin {
	
	private static ArrayList<BigInteger> factorials = new ArrayList<BigInteger>(Arrays.asList(new BigInteger("1"), new BigInteger("1")));

	public static void main(String[] args) {
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/ch/meccariello/factorials/factorials.txt")));
			for (int i = 0; i <= 1674; i++) {
				bw.write(i + "! = " + factorial(i) + "\n");
			}
			bw.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static BigInteger factorial(Object x) {
		if (new BigInteger(x + "").compareTo(new BigInteger((factorials.size() - 1) + "")) <= 0) return factorials.get((int) x);
		IntStream.range(factorials.size(), (int) x + 1).forEach(i -> factorials.add(factorials.get(factorials.size() - 1).multiply(new BigInteger(i + ""))));
		return factorials.get((int) x);
	}
	
}
