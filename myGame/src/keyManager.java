
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

import javazoom.jl.player.Player;

/**
 * This class makes the goal 
 * @author Kelvin
 * @author Senne
 * @author Corné
 * @author Jordy
 * @author Aran
 * 
 * @version 1.1 03/6/2017
 * @since 1.1
 * 
 * This class is used to move 
 * 
 *  Used sources:
 *  <ul>
 *	<li> http://stackoverflow.com/questions/2623995/swings-keylistener-and-multiple-keys-pressed-at-the-same-time
 *  </ul>
 */
public class keyManager implements KeyListener {
	
	private boolean[] keys; 
	public boolean up, down, left, right;
	public boolean kanIndrukken = true; 
	
	private final Set<Character> pressed = new HashSet<Character>();
	/**
	 * Constructor uses the keys array to fill it with booleans. 
	 */
	public keyManager(){
		keys = new boolean[256];
	}
	
	/**
	 * This method is used to update the keys W, S, A, D
	 */
	public void update(){
		/*up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		*/
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	/**
	 * If a key is pressed this method is called,
	 * When a key is already pressed, no other can be used. 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		pressed.add(e.getKeyChar());
		if (pressed.size() > 1) {
			keys[e.getKeyChar()] = false;
			kanIndrukken = false;
		}
		else
		{
			keys[e.getKeyCode()] = true;
		}
	}
	/**
	 * If a key is released this method is called,
	 * So a new key can be pressed.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		pressed.remove(e.getKeyChar());
		keys[e.getKeyCode()] = false;
		kanIndrukken = true;
	}
	/**
	 * This method is not used 
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}