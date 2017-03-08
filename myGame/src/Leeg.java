import java.awt.Color;
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
 * This class creates the empty tile 
 */
public class Leeg extends Tegel {
	/**
	 * Constructor takes the x and y, and give this to Tegel constructor with "super()"
	 * @param x ; Used for the horizontal position  
	 * @param y ; Used for the vertical position 
	 * @see Tegel Constructor 
	 */
	public Leeg(int x, int y) {
		super(x, y);
	
	}
	/**
	 * This method does nothing 
	 */
	@Override
	public int getPositie() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * This method does nothing 
	 */
	@Override
	public void update(keyManager keyManager) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This method does nothing 
	 */
	@Override
	public void render(Graphics g, BufferStrategy bs) {
		g.setColor(Color.WHITE);
		g.drawRect(super.positie.getX(), super.positie.getX(), 50, 50);
		bs.show(); 
		g.dispose();
	}

}
