
import java.awt.image.BufferedImage;

/**
 * @author Kelvin
 * @author Senne
 * @author Corné
 * @author Jordy
 * @author Aran
 * @version 1.1 03/6/2017
 * @since 1.1
 * 
 * This class makes it easy to implement images and sound in the Speelveld class
 */
public class Assets {

	public static BufferedImage speler, muur, doel;

	public static String biem, start, eind; 
	/**
	 * The init() is static so it can be accessed from everywhere.
	 * So in the other classes it will be: "Assets.muur" for example.
	 */
	public static void init(int level){
		if (level == 1)
		{
		muur = imageLoader.loadImage("/Plaatjes/dumpert.JPG");
		doel = imageLoader.loadImage("/Plaatjes/vis.JPG");
		speler = imageLoader.loadImage("/Plaatjes/speler.JPG");
		biem = ("Resources/Muziekjes/BIEM.MP3");
		start = ("Resources/Muziekjes/start.MP3");
		eind = ("Resources/Muziekjes/doodgestoken.MP3");
		}
		if (level == 2)
		{
		muur = imageLoader.loadImage("/Plaatjes/dumpert.JPG");
		doel = imageLoader.loadImage("/Plaatjes/kaas.JPG");
		speler = imageLoader.loadImage("/Plaatjes/kaasmevrouw.JPG");
		biem = ("Resources/Muziekjes/BIEM.MP3");
		start = ("Resources/Muziekjes/kaas.MP3");
		eind = ("Resources/Muziekjes/kut_kaas.MP3");
		}
		if (level == 3)
		{
		muur = imageLoader.loadImage("/Plaatjes/dumpert.JPG");
		doel = imageLoader.loadImage("/Plaatjes/dumpertreeten_ass.PNG");
		speler = imageLoader.loadImage("/Plaatjes/vanleeuwen.JPG");
		biem = ("Resources/Muziekjes/BIEM.MP3");
		start = ("Resources/Muziekjes/start.MP3");
		eind = ("Resources/Muziekjes/dikke_billen.MP3");
		}
	}

}
