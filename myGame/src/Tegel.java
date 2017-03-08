
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
 * This abstract class creates the tiles, these tiles can be: player, goal, empty or a wall. 
 * Moreover, Tegel is used by Speelveld 
 */

public abstract class Tegel{
	/**
	 * positie is used for location   
	 */
	protected Locatie positie;
	
	
	/**
     * A constructor.
     * The constructor inits the place from the tiles. These tiles can be the following objects: player, goal, empty or a wall. 
 	 * @param x ; Used for the horizontal position  
	 * @param y ; Used for the vertical position
	 * @see Speler
	 * @see Doel
	 * @see Muur
	 * @see Leeg
     */
	public Tegel(int x, int y){ 
		this.positie = new Locatie(x, y);
		// veld maken 
	}
	/**
	 * This method is abstract. 
	 * <br>
	 * for more detailed description:
	 * <br>
	 * @see Speler
	 * @see Doel
	 * @see Muur
	 * @see Leeg
	 *  
	 */
	public abstract int getPositie();
	/**
	 * This method is abstract 
	 * for more detailed description 
	 * @see Speler
	 * @see Doel
	 * @see Muur
	 * @see Leeg
	 * 
	 */
	public abstract void update(keyManager keyManager);
	/**
	 * This method is abstract 
	 * for more detailed description 
	 * @see Speler
	 * @see Doel
	 * @see Muur
	 * @see Leeg
	 * for more detailed description 
	 */
	public abstract void render(Graphics g, BufferStrategy bs);


	
}
