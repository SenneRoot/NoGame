import java.util.Scanner;

/**
 * This class makes the goal 
 * @author Kelvin
 * @author Senne
 * @author Corné
 * @author Jordy
 * @author Aran
 * 
 * @version 1.1 03/6/2017
 * @since 1.0
 * 
 * This class is the main which is used for starting the game
 * 
 *  Used sources:
 *  <ul>
 *  <li> http://docs.oracle.com/javase/tutorial/uiswing/painting/step1.html
 *	<li> https://github.com/CodeNMore/New-Beginner-Java-Game-Programming-Src/blob/master/Episode%204/TileGame/src/dev/codenmore/tilegame/Game.java
 *  </ul>
 */

public class MainFrame {

	private static final int breedte = 12, lengte = 10;
	private static int level = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("select level:");
		Scanner sc = new Scanner(System.in);
		level = sc.nextInt();
		sc.close();
		// start game 
		//hier moet nog:
		//vragen naar een level via console
		//als dit een onjuiste waarde is (!= 1 | 2 | 3)
		//stop
		//anders
		//level variable hier naar aanpassen
		//en het spel starten
		System.out.println(level);
		if(level == 1 || level == 2 || level == 3)
		{
		System.out.println("starting game..");
		Speelveld veld = new Speelveld(breedte, lengte, level);
		veld.start(); 
		}
		else
		{
			System.out.println("verkeerd level");
			System.exit(1);
		}
	
	}

}
