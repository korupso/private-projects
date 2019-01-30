package ch.meccariello.blackjack;

public class Table {
	
	public static boolean playerCard = true; 
	public static Card[] newestCards = new Card[2];
	private static boolean isBust = false;
	
	public static int getScore(String player) {
		int score = 0;
		for (Card card : Blackjack.hands.get(player)) {
			score += card.getValue();
		}
		return score;
	}
	
	public static boolean gameIsDone() {
		return isBust;
	}
	
}
