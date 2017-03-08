
	import java.awt.image.BufferedImage;
	import java.io.IOException;

	import javax.imageio.ImageIO;
	/**
	 *  
	 * @author Kelvin
	 * @author Senne
	 * @author Corné
	 * @author Jordy
	 * @author Aran
	 * 
	 * @version 1.1 03/6/2017
	 * @since 1.1
	 * 
	 * This class is used for BufferImageStrategy 
	 */
	public class imageLoader {

		public static BufferedImage loadImage(String path){
			try {
				return ImageIO.read(imageLoader.class.getResource(path));
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
			return null;
		}
		
	}

