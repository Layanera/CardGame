package card.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Field 
{
	public final static int CARDS_PER_SIDE = 6;
	
	private ActionListener listener;
	public static Card[] playerCards;
	public static Card[] enemyCards;
	public static Button[] playerCardButtons;
	public static Button[] enemyCardButtons;
	
	public Field()
	{
		playerCards = new Card[CARDS_PER_SIDE];
		enemyCards = new Card[CARDS_PER_SIDE];
		
		playerCardButtons = new Button[CARDS_PER_SIDE];
		enemyCardButtons = new Button[CARDS_PER_SIDE];
		
		for(int i = 0; i < CARDS_PER_SIDE; i++)
			playerCardButtons[i] = new Button(Game.frame.getWidth()/2-(210*CARDS_PER_SIDE)/2+15+(210*i), 50, Card.WIDTH, Card.HEIGHT);
		
		for(int j = 0; j < CARDS_PER_SIDE; j++)
			playerCardButtons[j] = new Button(Game.frame.getWidth()/2-(210*CARDS_PER_SIDE)/2+15+(210*j), 380, Card.WIDTH, Card.HEIGHT);
		
		listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		};
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(222,89,38));
		for(int i = 0; i < CARDS_PER_SIDE; i++)
		{
		 	g.drawRect(Game.frame.getWidth()/2-(210*CARDS_PER_SIDE)/2+15+(210*i), 50, Card.WIDTH, Card.HEIGHT);
		 	if(enemyCards[i] != null)
		 		g.drawImage(enemyCards[i].getImg(), Game.frame.getWidth()/2-(210*CARDS_PER_SIDE)/2+15+(210*i), 50, null);
		}
		
		g.setColor(new Color(255,255,198));
		for(int j = 0; j < CARDS_PER_SIDE; j++)
		{
		 	g.drawRect(Game.frame.getWidth()/2-(210*CARDS_PER_SIDE)/2+15+(210*j), 380, Card.WIDTH, Card.HEIGHT);
		 	if(playerCards[j] != null)
		 		g.drawImage(playerCards[j].getImg(), Game.frame.getWidth()/2-(210*CARDS_PER_SIDE)/2+15+(210*j), 380, null);
		}
		
		g.setColor(new Color(98,137,187));
		for(int k = 0; k < Game.player.getCardsOnHand(); k++)
		{
		 	g.drawRect(Game.frame.getWidth()/2-(210*Game.player.getCardsOnHand())/2+15+(210*k), 710, Card.WIDTH, Card.HEIGHT);
		 	g.drawImage(Game.player.getCard(k).getImg(), Game.frame.getWidth()/2-(210*Game.player.getCardsOnHand())/2+15+(210*k), 710, null);
		}
	}
}
