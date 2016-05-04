package card.game;

import java.awt.image.BufferedImage;

public class Card 
{
	public static final int WIDTH = 180;
	public static final int HEIGHT = 280;
	public static final int[] PERMITTED_CARD_IDS = {0};
	
	private BufferedImage img;
	private int id;
	private int hp;
	private int atk;
	private int cost;
	
	public Card(int id)
	{
		for(int i : PERMITTED_CARD_IDS)
		{
			if(i == id)
			{
				this.id = id;
				this.img = ResourceLoader.getImage(id);
				DBManager.CardData cd = DBManager.getCardDataFromDatabase(id);
				this.hp = cd.hp;
				this.atk = cd.atk;
				this.cost = cd.cost;
				//System.out.println(cd.name+"\n"+cd.desc);
				return;
			}
		}
		System.out.println("[ERROR]: Unknown card id");
	}

	public int getId() 
	{
		return id;
	}

	public BufferedImage getImg() 
	{
		return img;
	}

	public int getHp() 
	{
		return hp;
	}

	public int getAtk() 
	{
		return atk;
	}
	
	public int getCost()
	{
		return cost;
	}
}
