
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * 
 * @author Kelvin
 * @author Senne
 * @author Corné
 * @author Jordy
 * @author Aran
 * 
 * @version 1.1 03/6/2017
 * @since 1.0
 * 
 * This class creates the player
 */
public class Speler extends Tegel {

	/**
	 * Constructor takes the x and y, and give this to Tegel constructor with "super()"
	 * @param x ; Used for the horizontal position  
	 * @param y ; Used for the vertical position 
	 * @see Tegel Constructor 
	 */
	public Speler(int x, int y) {
		super(x, y);
	}
	/**
	 * This method does nothing 
	 */
	@Override
	public int getPositie() {
		
		return 0;
	}
	/**
	 * This method updates the position of the player when a key is pressed 
	 * @param keyManger ; Listen to key
	 * 
	 * If keyManger is true, position can be changed, otherwise it will move on an on.
	 * Then it will check which key was pressed. 
	 * It uses SetXY from the positie class, this one takes the direction from the enum Richting.
	 * @see positie
	 * @see Richting
	 * @see keyManager
	 */
	@Override
	public void update(keyManager keyManager) {
		if(keyManager.kanIndrukken)
		{
			if(keyManager.up)
			{
				super.positie.setXY(Richting.NOORD); 
				keyManager.kanIndrukken = false;
			}
			if(keyManager.left)
			{
				 super.positie.setXY(Richting.WEST); 
				 keyManager.kanIndrukken = false;
			}
			if(keyManager.right)
			{
			 super.positie.setXY(Richting.OOST); 
			 keyManager.kanIndrukken = false;
			}
			if(keyManager.down)
			{
			 super.positie.setXY(Richting.ZUID);
			 keyManager.kanIndrukken = false;
			}	
		}
	}
	/**
	 * This method renders the player.
	 * @param g ; Used for the Graphics 
	 * @param bs; Used for the bufferstrategy 
	 * 
	 * It uses the Assets class and the positions to draw himself. 
	 * This method is used by the 2d array from tiles in Speelveld.
	 */
	@Override
	public void render(Graphics g, BufferStrategy bs) {
		g.drawImage(Assets.speler, super.positie.getX(), super.positie.getY(), null);
		bs.show(); 
		g.dispose();
		
	}
	/**
	 * This class renders the player.
	 * @param keyManager ; Listen to key
	 * @return Richting ; can be NORTH, WEST, EAST or SOUTH
	 * 
	 * This method is used to check the neighbourfield in Speelveld.
	 *  
	 */
	public Richting getRichting(keyManager keyManager)
	{
		// if KanIndrukken is false, return null.
		if(keyManager.kanIndrukken)
		{
			if(keyManager.up)
			{
				return Richting.NOORD; 
			}
			if(keyManager.left)
			{
				return Richting.WEST; 
			}
			if(keyManager.right)
			{
				return Richting.OOST;
			}
			if(keyManager.down)
			{
				return Richting.ZUID;
			}	
		}
		return null; 
	}
	
	
	
}
