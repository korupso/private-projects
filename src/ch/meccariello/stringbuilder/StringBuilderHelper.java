package ch.meccariello.stringbuilder;

import java.util.Scanner;

public class StringBuilderHelper {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("ID: ");
		int id = Integer.valueOf(sc.nextLine());
		System.out.print("String: ");
		String string = sc.nextLine();
		sc.close();
		for (int i = 0; i < string.length(); i++) {
			System.out.println("INSERT INTO StringBuilder(String, Keycode, Position) VALUES (" + id + ", " + (int) string.charAt(i) + ", " + i + ");");
		}
		
	}

}
