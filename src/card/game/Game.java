package card.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Game 
{
	private final static int TIME_PER_FRAME = 1000/60;
	
	private static int round;
	
	public static JFrame frame;
	public static Player player;
	private static Button nextRoundButton;
	private static Field field;
	
	public static void main(String[] args)
	{
		player = new Player(1, "Player", -1);
		nextRoundButton = new Button(1490,320,90,90);
		
		round = 1;
		
		nextRoundButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				round++;
				player.setMana(player.getMana() + 1);
				if(player.getCardsOnHand() < Player.MAX_CARDS_ON_HAND)
					player.pullCard();
				System.out.println(round);
			}
		});
		frame = new JFrame();
		frame.setSize(1700, 1050);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		field = new Field();
		
		frame.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				 nextRoundButton.update(arg0.getX(), arg0.getY());
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i = 0; i < 4; i++)
			player.pullCard();
		
		frame.createBufferStrategy(2);
		BufferStrategy strategy = frame.getBufferStrategy();
		long startTime = 0, endTime = 0;
		
		while(true) 
		{
			startTime = System.currentTimeMillis();
		     do 
		     {
		         do 
		         {
		             Graphics graphics = strategy.getDrawGraphics();
		             
		             render((Graphics2D)graphics);
		             
		             graphics.dispose();
		             
		             try
		 			 {
		 				endTime = System.currentTimeMillis();
		 				if(endTime-startTime < TIME_PER_FRAME && TIME_PER_FRAME-(endTime-startTime) > 0)
		 					Thread.sleep(TIME_PER_FRAME-(endTime-startTime));
		 			 }
		 			 catch (InterruptedException e)
		 			 {
		 				e.printStackTrace();
		 			 }
		         }while (strategy.contentsRestored());
		         strategy.show();
		     }while(strategy.contentsLost());
		}
		//frame.dispose();
	}

	private static void render(Graphics2D g)
	{
		g.setColor(new Color(163,185,126));
		g.fillRect(0,0,Integer.MAX_VALUE,Integer.MAX_VALUE);
		g.setColor(new Color(126,163,185));
		g.fillRect(0, 685, 4000, 4000);
		g.setStroke(new BasicStroke(5));
		
		field.render(g);
		
		nextRoundButton.render(g);
	}
}
