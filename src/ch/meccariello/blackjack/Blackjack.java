package ch.meccariello.blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Blackjack {
	
	static HashMap<String, ArrayList<Card>> hands;
	
	public static void main(String[] args) {
		
		Deck deck = new Deck();
		
		while (true) {
			hands = new HashMap<String, ArrayList<Card>>() {{
				put("Player", new ArrayList<Card>());
				put("House", new ArrayList<Card>());
			}};
			
			deck.takeCard(hands.get("Player"));
			deck.takeCard(hands.get("House"));
			System.out.println("Player: " + Table.getScore("Player") + " " + hands.get("Player") + "\nHouse: " + Table.getScore("House") + " " + hands.get("House"));
			System.out.println("1: Yes; 0: No");
			convertAce();
			
			// Player's turn
			while (true) {
				System.out.print("\nTake another one? ");
				Scanner sc = new Scanner(System.in);
				String another = sc.nextLine();
				sc.close();
				if ("0".equals(another)) break;
				deck.takeCard(hands.get("Player"));
				System.out.println("\nYou picked up: " + hands.get("Player").get(hands.get("Player").size() - 1));
				convertAce();
				System.out.println("Player: " + Table.getScore("Player") + " " + hands.get("Player"));
				if (Table.getScore("Player") > 21) {
					System.out.println("Bust!");
					break;
				}
			}
			
			System.out.println();
			
			// House's turn
			while (true) {
				if (Table.getScore("Player") > 21) {
					System.out.println("Player lost!");
					break;
				}
				if (Table.getScore("House") > 21) {
					System.out.println("Player won!");
					break;
				}
				if (Table.getScore("House") <= Table.getScore("Player") && Table.getScore("House") <= 21) {
					deck.takeCard(hands.get("House"));
					System.out.println("\nHouse picked up: " + hands.get("House").get(hands.get("House").size() - 1));
					System.out.println("House: " + Table.getScore("House") + " " + hands.get("House") + "\n");
				} else {
					System.out.println("Player lost!");
					break;
				}
			}
			System.out.println();
		}
		
		
		
	}
	
	public static void convertAce() {
		if (hands.get("Player").get(hands.get("Player").size() - 1).getValue() == 1) {
		System.out.print("Convert ace? ");
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		if ("1".equals(answer)) {
			hands.get("Player").set(hands.get("Player").size() - 1, new Card(hands.get("Player").get(hands.get("Player").size() - 1).toString(), "11"));
			System.out.println("Player: " + Table.getScore("Player") + " " + hands.get("Player"));
		}
		System.out.println();
		sc.close();
	}
		
	}
	
}
