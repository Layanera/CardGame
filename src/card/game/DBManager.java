package card.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager 
{
	private static final String DB_FILE = "data.db";
	
	private static Connection dbcon;
	
	private static PreparedStatement getCardData = null;
	
	static
	{
		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			dbcon = DriverManager.getConnection("jdbc:sqlite:C:/Libs/"+DB_FILE);
			getCardData = dbcon.prepareStatement("SELECT * FROM cards WHERE id=?");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static CardData getCardDataFromDatabase(int id)
	{
		try
		{
			ResultSet card = null;
			getCardData.setInt(1, id);
			if(getCardData.execute())
				card = getCardData.getResultSet();
			if(card.next())
				return new CardData(card.getString("name"),card.getInt("atk"),card.getInt("hp"),card.getInt("cost"),card.getString("desc"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static class CardData
	{
		public String name;
		public int atk;
		public int hp;
		public int cost;
		public String desc;
		
		public CardData(String string, int int1, int int2, int int3, String string2)
		{
			name = string;
			atk = int1;
			hp = int2;
			cost = int3;
			desc = string2;
		}
	}
}