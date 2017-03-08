

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javazoom.jl.player.*;
import java.io.FileInputStream;

import javax.swing.JFrame;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import java.util.Random;
/**
 * @author Kelvin
 * @author Senne
 * @author Corné
 * @author Jordy
 * @author Aran
 * @version 1.1 03/6/2017
 * @since 1.1
 * 
 * This class makes is to create the playing field
 */

public class Speelveld implements Runnable {
		private Canvas canvas;
		private JFrame frame;
		private final String title;
		private final int aantalRijen; 
		private final int aantalKolommen; 
		private final int level;
		
		private int doelx;
		private int doely;
		int x = 0;
		private Tegel[][] veld; 
		
		private BufferStrategy bs;
		private Graphics g;
		
		
		private boolean eersteKeer = true; 
		private boolean running = false;
		private Thread thread;

		private keyManager keyManager;
		private Tegel muur;
		private Tegel speler;
		
		private final static int AANTALPIXELS = 50; 
		/**
	     * A constructor.
	     * A more elaborate description of the constructor.
	     * @param aantalRijen ;is de hoogte van het frame 
	     * @param aantalKolommen ;is de breedte van het frame
	     * @param level ;het geselcteerde level
	     */
		public Speelveld (int aantalRijen, int aantalKolommen, int level)
		{
			this.aantalRijen = aantalRijen * AANTALPIXELS;
			this.aantalKolommen = aantalKolommen * AANTALPIXELS;
			this.title = "NoGame";
			this.level = level;
			this.veld = new Tegel[aantalKolommen][aantalRijen]; 
		}
		
		/**
		 * method to create a display to display the graphics
		 * uses Jframe and a Canvas
		 */
		private void createDisplay()
		{
			frame = new JFrame(title);
			frame.setSize(aantalKolommen, aantalRijen);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			canvas = new Canvas();
			canvas.setPreferredSize(new Dimension(aantalKolommen, aantalRijen));
			canvas.setMaximumSize(new Dimension(aantalKolommen, aantalRijen));
			canvas.setMinimumSize(new Dimension(aantalKolommen, aantalRijen));
			canvas.setFocusable(false);
			
			frame.add(canvas);
			frame.pack();
		}

		/**
		 * This is the init which will initialize all the things the game needs to run 
		 */
		private void init(){
			createDisplay();
			Random rn = new Random();
			doelx = rn.nextInt((aantalKolommen/AANTALPIXELS)-1)+2;
			doely = rn.nextInt((aantalRijen/AANTALPIXELS)-1)+2;
			keyManager = new keyManager();
			frame.addKeyListener(keyManager);
			Assets.init(level);
			
			for(int i = 0; i < aantalKolommen/AANTALPIXELS; i++)
			{
				for(int j = 0; j < aantalRijen/AANTALPIXELS; j++)
				{
					if(j == 0 || j == (aantalRijen/AANTALPIXELS) -1){
						muur = new Muur(i, j); 
						this.veld[i][j] = muur; 
					}	  
					else if(i == 0 || i == (aantalKolommen/AANTALPIXELS) -1){
						muur = new Muur(i,j);
						veld[i][j] = muur; 
					}
					else if(i == doelx && j == doely)
					{
						Tegel doel = new Doel(i,j);
						veld[i][j] = doel; 	
					}
					else if(i == 1 && j == 1)
					{
						Tegel speler = new Speler(1,1);
						veld[i][j] = speler; 	
					}
					else 
					{	
						Tegel leeg = new Leeg(i,j); 
						veld[i][j] = leeg; 
					}		
				} // for
				
			} // for 


		}
		
		/**
		 * This function checks if the player moves and if the player can move if so it updates its position or plays a sound when they cant move
		 */
		private void update(){
			keyManager.update();

			bs = canvas.getBufferStrategy();
			if(bs == null){
				canvas.createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();

			
				for(int i = 0; i < aantalKolommen/AANTALPIXELS; i++)
				{
					for(int j = 0; j < aantalRijen/AANTALPIXELS; j++)
					{
						if(veld[i][j] instanceof Speler)
						{
							if((((Speler) veld[i][j]).getRichting(keyManager) != null))
							{
								
								// aanvragen 
								Richting buurVeld =  ((Speler) veld[i][j]).getRichting(keyManager); 
								if(veld[i + buurVeld.getX()][j + buurVeld.getY()] instanceof Muur)
								{
									System.out.println("Biem");

									try{
										FileInputStream fis = new FileInputStream(Assets.biem);
							             Player playMP3 = new Player(fis);

							             playMP3.play();

							        }  catch(Exception e){
							             System.out.println(e);
							           }
								}
									//maak geluid
									// en laat niet toe
								else if(veld[i + buurVeld.getX()][j + buurVeld.getY()] instanceof Doel)	{
									//hier moet nog een eind geluid worden afgespeeld, toevoegen aan assets dus
									try{
										FileInputStream fis = new FileInputStream(Assets.eind);
							             Player playMP3 = new Player(fis);

							             playMP3.play();

							        }  catch(Exception e){
							             System.out.println(e);
							           }
									System.exit(0);
									stop();
								}
								else 
									// het kan
								{
									veld[i][j].update(keyManager);
									veld[i + buurVeld.getX()][j + buurVeld.getY()] = veld[i][j];
									veld[i][j] = new Leeg(i,j); 
								}
								// en dan verplaatsen
								
							}
							
						}
					}  // for
					
				} // for
	
			 
				bs.show();
				g.dispose();
				if (eersteKeer)
				{
					try{
						FileInputStream fis = new FileInputStream(Assets.start);
			             Player playMP3 = new Player(fis);

			             playMP3.play();

			        }  catch(Exception e){
			             System.out.println(e);
			           }
					eersteKeer = false;
				}
		}
		
		/**
		 * This method will start the gameloop
		 */
		public void run(){
			
			init();
			
			int fps = 30;
			double timePerTick = 1000000000 / fps;
			double delta = 0;
			long now;
			long lastTime = System.nanoTime();
			long timer = 0;
			int ticks = 0;
			
			while(running){
				now = System.nanoTime();
				delta += (now - lastTime) / timePerTick;
				timer += now - lastTime;
				lastTime = now;
				
				if(delta >= 1)
				{
				update();
				render();
				ticks++;
				delta--;
				}
				if(timer >= 1000000000){
					//System.out.println("Ticks and Frames: " + ticks);
					ticks = 0;
					timer = 0;
				}
			}
			
			stop();
			
		}
		
		/**
		 * This method renders all the stuff on the canvas according to the positions given in the veld[][] array
		 */
		private void render(){
			bs = canvas.getBufferStrategy();
			if(bs == null){
				canvas.createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();
			
			//Draw Here!
			g.clearRect(0, 0, aantalKolommen, aantalRijen);

			for(int i = 0; i < aantalKolommen/AANTALPIXELS; i++)
			{
				for(int j = 0; j < aantalRijen/AANTALPIXELS; j++)
				{
					if(veld[i][j] instanceof Muur)
					{
						g.drawImage(Assets.muur, i * AANTALPIXELS, j*AANTALPIXELS, null);
					}
					if(veld[i][j] instanceof Doel)
					{
						g.drawImage(Assets.doel, i * AANTALPIXELS, j*AANTALPIXELS, null);
					}
					else if(veld[i][j] instanceof Leeg || veld[i][j] instanceof Speler)
					{
						g.setColor(Color.WHITE);
						g.fillRect(i *50 , j*50, 50, 50);
					}
					if(veld[i][j] instanceof Speler)
					{	
						g.drawImage(Assets.speler, i*AANTALPIXELS, j*AANTALPIXELS, null);
					}
				}
				
			} // for
			//End Drawing!
			bs.show();
			g.dispose();
		}
		
		/**
		 * Method to start the thread on which the game will run 
		 */
		public synchronized void start(){
			if(running)
				return;
			running = true;
			thread = new Thread(this);
			thread.start();
		}
		/**
		 * Method to stop the thread on which the game will run 
		 */
		public synchronized void stop(){
			if(!running)
				return;
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

}
