package card.game;

import java.util.ArrayList;

public class Deck 
{
	private int id;
	private int playerid;
	private ArrayList<Card> deck;
	
	public Deck(int id)
	{
		deck = new ArrayList<>();
		if(id == -1)
		{
			for(int i = 0; i < 20; i++)
				deck.add(new Card(Card.PERMITTED_CARD_IDS[(int)(Math.random()*Card.PERMITTED_CARD_IDS.length)]));
		}
	}
	
	public int getId() 
	{
		return id;
	}

	public int getPlayerId() 
	{
		return playerid;
	}
	
	public int getSize()
	{
		return deck.size();
	}
	
	public Card getCard(int position)
	{
		return deck.get(position);
	}
	
	public void removeCard(int position)
	{
		deck.remove(position);
	}

	public void load()
	{
		
	}

}
