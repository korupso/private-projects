package ch.meccariello.dye;

public class Dye {
	
	private static char[] dice = new char[] {'⚀', '⚁', '⚂', '⚃', '⚄', '⚅'};
	
	public static void main(String[] args) {
		for (char dye : dice) {
			System.out.println(dye);
		}
	}
	
}
