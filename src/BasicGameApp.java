//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.tools.Tool;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

   //Variable Definition Section
   //Declare the variables used in the program 
   //You can set their initial values too
   
   //Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 800;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
   public JPanel panel;
   
	public BufferStrategy bufferStrategy;
	public Image foxPic;
    public Image harePic;
    public Image flyPic;
    public Image Background;

   //Declare the objects used in the program
   //These are things that are made up of more than one variable type
	private Fox fox1;
    private Fox fox2;
    private Hare hare1;
    private Hare hare2;
    private Butterfly butterfly1;
    private Butterfly butterfly2;

   // Main method definition
   // This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method  
	}


   // Constructor Method
   // This has the same name as the class
   // This section is the setup portion of the program
   // Initialize your variables and construct your program objects here.
	public BasicGameApp() {
      
      setUpGraphics();
       
      //variable and objects
      //create (construct) the objects needed for the game and load up 
		foxPic = Toolkit.getDefaultToolkit().getImage("fox.png"); //load the picture
        harePic = Toolkit.getDefaultToolkit().getImage("hare.jpg");
        flyPic = Toolkit.getDefaultToolkit().getImage("monarch");
        Background = Toolkit.getDefaultToolkit().getImage("Forest.jpg");
		fox1 = new Fox (10,430);
        fox2 = new Fox (500, 700);
        hare1 = new Hare(20, 450, 4, 3, 60, 60);
        hare2 = new Hare(750, 500, -2, -5, 45, 45);
        butterfly1 = new Butterfly(100, 20);
        butterfly2 = new Butterfly(850, 50);

	}// BasicGameApp()

   
//*******************************************************************************
//User Method Section
//
// put your code to do things here.

   // main thread
   // this is the code that plays the game after you set things up
	public void run() {

      //for the moment we will loop things forever.
		while (true) {

         moveThings();  //move all the game objects
         render();  // paint the graphics
         pause(20); // sleep for 10 ms
		}
	}


	public void moveThings()
	{
      //calls the move( ) code in the objects
		fox1.move();
        fox2.move();
        hare1.move();
        hare2.move();
        butterfly1.move();
        butterfly2.move();

        //when foxes collide they get disoriented
        //hares make a new hare
        // add carrots... when hare meets carrot, gets bigger
        // hare x fox...fox gets bigger, hare disapears
        //
	}
	
   //Pauses or sleeps the computer for the amount specified in milliseconds
   public void pause(int time ){
   		//sleep
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }

   //Graphics setup method
   private void setUpGraphics() {
      frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
   
      panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
      panel.setLayout(null);   //set the layout
   
      // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
      // and trap input events (Mouse and Keyboard events)
      canvas = new Canvas();  
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
   
      panel.add(canvas);  // adds the canvas to the panel.
   
      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
      frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
      frame.setResizable(false);   //makes it so the frame cannot be resized
      frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
      
      // sets up things so the screen displays images nicely.
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");
   
   }


	//paints things on the screen using bufferStrategy
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(Background, 0, 0, WIDTH, HEIGHT, null);
      //draw the image of the foxes
		g.drawImage(foxPic, fox1.xpos, fox1.ypos, fox1.width, fox1.height, null);
        g.drawImage(foxPic, fox2.xpos, fox2.ypos, fox2.width, fox2.height, null);
        //draw images of the hares
        g.drawImage(harePic, hare1.xpos, hare1.ypos, hare1.width, hare1.height, null);
        g.drawImage(harePic, hare2.xpos, hare2.ypos, hare2.width, hare2.height, null);

		g.dispose();

		bufferStrategy.show();
	}
}