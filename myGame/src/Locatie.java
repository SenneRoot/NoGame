
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
 * This class is used to store the location of a tile.
 * And set it or give it back 
 * 
 */
public class Locatie {
	private int X;
	private int Y;
	/**
	 * 
	 * @param x ; Used for the horizontal position 
	 * @param y ; Used for the vertical position
	 */
	//constructor 
	public Locatie(int x, int y){
		this.X = x; 
		this.Y = y; 
	}
	/**
	 * 
	 * @return x ; it is multiplied by 50 to represent the pixels
	 */
	public int getX(){
		return (this.X * 50); 
	}
	/**
	 * 
	 * @return y ; it is multiplied by 50 to represent the pixels
	 */
	public int getY(){
		return (this.Y * 50); 
	}
	/**
	 * This method is used to set the x and y coordinates 
	 * @param x ; Used for the horizontal position 
	 * @param y ; Used for the vertical position
	 */
	public void setXY(Richting richting){
		//controle komen
		 this.X += (richting.getX()); 
		 this.Y += (richting.getY()); 
	}
	

}
