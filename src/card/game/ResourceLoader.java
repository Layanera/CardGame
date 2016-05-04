package card.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ResourceLoader
{
	private static HashMap<Integer,BufferedImage> images;
	
	static
	{
		try
		{
			images = new HashMap<>();
			for(int i : Card.PERMITTED_CARD_IDS)
				images.put(i, ImageIO.read(new File("images/"+i+".png")));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static BufferedImage getImage(int id)
	{
		return images.get(id);
	}

}