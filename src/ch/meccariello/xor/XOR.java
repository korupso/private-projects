package ch.meccariello.xor;

public class XOR {
	
	public static void main(String[] args) {

		System.out.println(xorLong(false, false));
		System.out.println(xorLong(false, true));
		System.out.println(xorLong(true, false));
		System.out.println(xorLong(true, true));
		
	}
	
	/*
	 * AND
	 * 00|0
	 * 01|0
	 * 10|0
	 * 11|1
	 * 
	 * OR
	 * 00|0
	 * 01|1
	 * 10|1
	 * 11|1
	 * 
	 * XOR
	 * 00|0
	 * 01|1
	 * 10|1
	 * 11|0
	 */
	
	public static boolean xor(boolean a, boolean b) {
		
		return (a || b) && !(a && b);
		
	}
	
	public static boolean xorLong(boolean a, boolean b) {
		
		return a && !b;
		
	}
	
}
