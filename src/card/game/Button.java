package card.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Button 
{
	private int posX;
	private int posY;
	private int width;
	private int height;
	private BufferedImage img;
	private ArrayList<ActionListener> listeners;
	private Color c;
	
	public Button(int x, int y, int width, int height)
	{
		listeners = new ArrayList<>();
		posX = x;
		posY = y;
		this.width = width;
		this.height = height;
	}
	
	public Button(int x, int y, int width, int height, BufferedImage img)
	{
		new Button(x, y, width, height);
		this.img = img;
	}
	
	public void addActionListener(ActionListener listener)
	{
		listeners.add(listener);
	}
	
	public void removeActionListener(ActionListener listener)
	{
		listeners.remove(listener);
	}
	
	public void update(int mouseX, int mouseY)
	{
		if(mouseX >= posX && mouseX <= posX+width && mouseY >= posY && mouseY <= posY+height)
			for(ActionListener l : listeners)
				l.actionPerformed(new ActionEvent(this,ActionEvent.ACTION_PERFORMED,"none"));
	}
	
	public void render(Graphics g)
	{
		c = g.getColor();
		g.setColor(Color.BLACK);
		if(img != null)
			g.drawImage(img, posX, posY, null);
		else
			g.fillRect(posX, posY, width, height);
		g.setColor(c);
	}

	public int getPosX() 
	{
		return posX;
	}

	public int getPosY() 
	{
		return posY;
	}

	public BufferedImage getImg() 
	{
		return img;
	}

	public int getWidth()  
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}
}
