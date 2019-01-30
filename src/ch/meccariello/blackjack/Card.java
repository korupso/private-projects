package ch.meccariello.blackjack;

/**
 * This file is used to create the structure for the cards.
 * 
 * @author Joel Meccariello
 *
 */
public class Card {
	
	private String name;
	private int value;

	/**
	 * This constructor creates a new card,
	 * using the name given by a parameter and also the value given by a parameter.
	 * 
	 * @param name The name of the card.
	 * @param value The value of the card.
	 */
	public Card(String name, String value) {
		super();
		this.name = name;
		this.value = Integer.parseInt(value);
	}
	
	/**
	 * @return Returns the card as readable string.
	 */
	@Override
	public String toString() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
}
