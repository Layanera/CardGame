package card.game;

import java.util.ArrayList;

public class Player 
{
	public static final int MAX_CARDS_ON_HAND = 8;
	
	public int id;
	public String name;
	public ArrayList<Card> hand;
	private Deck deck;
	private int mana;
	
	public Player(int id, String name, int deckId)
	{
		this.id = id;
		this.name = name;
		hand = new ArrayList<>();
		deck = new Deck(deckId);
		mana = 3;
	}
	
	
	public void pullCard()
	{
		int pos = (int)(Math.random()*deck.getSize());
		hand.add(deck.getCard(pos));
		deck.removeCard(pos);
	}
	
	public void playCard(int pos)
	{
		int i = 0;
		while(Field.playerCards[i] != null)
			i++;
		Field.playerCards[i] = hand.get(pos);
		hand.remove(pos);
	}
	
	public int getCardsOnHand()
	{
		return hand.size();
	}
	
	public Card getCard(int number)
	{
		return hand.get(number);
	}

	public int getMana() 
	{
		return mana;
	}

	public void setMana(int mana) 
	{
		this.mana = mana;
	}
}
