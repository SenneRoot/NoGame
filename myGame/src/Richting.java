/**
 * @author Kelvin
 * @author Senne
 * @author Corné
 * @author Jordy
 * @author Aran
 * @version 1.1 03/6/2017
 * @since 1.1
 * 
 * 
 * Enum gives the direction NORTH, EAST, WEST and SOUTH
 */
public enum Richting {
	NOORD(0, -1), 
	OOST(1, 0),
	ZUID(0, 1), 
	WEST(-1,0); 
	
	private int dr, dk; 
	/**
	 * Constructor used to fill the coordinates 
	 * @param dr ; represent the x
	 * @param dk ; represent the y
	 */
	private Richting(int dr, int dk)
	{
		this.dr = dr; 
		this.dk = dk; 
	}
	/**
	 * 
	 * @return dr ; aka X 
	 */
	public int getX() {return dr;}
	/**
	 * 
	 * @return dk ; aka Y
	 */
	public int getY() {return dk;}
}


