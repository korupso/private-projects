package ch.meccariello.blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is used to manage the cards.
 * Being able to take cards from the deck and to add a new deck to itself.
 * 
 * @author Joel Meccariello
 *
 */
public class Deck {
	
	static ArrayList<Card> cards;
	static ArrayList<Card> used;
	
	/**
	 * This constructor generates every card in a new deck.
	 */
	public Deck() {
		cards = new ArrayList<Card>() {{
			String[] colors = {"Hearts", "Spades", "Diamonds", "Clubs"};
			String[] numbers = {"1_Ace", "6_Six", "7_Seven", "8_Eight", "9_Nine", "10_Ten", "10_Jack", "10_Queen", "10_King"};
			for (int i = 0; i < colors.length; i++) {
				for (int j = 0; j < numbers.length; j++) {
					add(new Card(numbers[j].split("_")[1] + " of " + colors[i], numbers[j].split("_")[0]));
				}
			}
		}};
		
		Collections.shuffle(cards);
		
		used = new ArrayList<Card>();
	}
	
	/**
	 * This method chooses a random, unused card from the deck.
	 * If every card has been used the deck is shuffled and a new card is chosen.
	 * 
	 * @return Returns a random card, chosen from the deck.
	 */
	public String takeCard(ArrayList<Card> hand) {
		if (cards.isEmpty()) {
			System.out.println("Shuffling..");
			cards = used;
			Collections.shuffle(cards);
			used = new ArrayList<Card>();
		}
		Card card = cards.get(0);
		hand.add(card);
		used.add(card);
		cards.remove(0);
		return card.toString();
	}
	
	/**
	 * This method adds a new deck of cards to the already existing deck.
	 * Using multiple decks makes it harder to count the cards.
	 * 
	 * @return Returns the combined deck for one-liner code.
	 */
	public ArrayList<Card> addDeck() {
		cards.addAll(cards);
		return cards;
	}
}
