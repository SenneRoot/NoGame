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
 * This class makes the goal 
 */
public class Doel extends Tegel{
	/**
	 * Constructor takes the x and y, and give this to Tegel constructor with "super()"
	 * @param x ; Used for the horizontal position  
	 * @param y ; Used for the vertical position 
	 * @see Tegel Constructor 
	 */
	public Doel(int x, int y) {
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
		
		g.drawImage(Assets.doel, super.positie.getX(), super.positie.getY(), null);
		bs.show(); 
		g.dispose();
	}

}
