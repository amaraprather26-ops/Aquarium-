/**
 * Created by chales on 11/6/2017.
 */
public class Fox {

    //VARIABLE DECLARATION SECTION
    //Here's where you state which variables you are going to use.
    public String name;             //holds the name of the hero
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int dx;                    //the speed of the hero in the x direction
    public int dy;                    //the speed of the hero in the y direction
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.


    // METHOD DEFINITION SECTION

    // Constructor Definition
    // A constructor builds the object when called and sets variable values.


    //This is a SECOND constructor that takes 3 parameters.  This allows us to specify the hero's name and position when we build it.
    // if you put in a String, an int and an int the program will use this constructor instead of the one above.
    public Fox (int pXpos, int pYpos, int xspeed, int yspeed) {
        xpos = pXpos;
        ypos = pYpos;
        dx = xspeed;
        dy = yspeed;
        width = 90;
        height = 90;
        isAlive = true;

    } // constructor

    //The move method.  Everytime this is run (or "called") the hero's x position and y position change by dx and dy
    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;
        //makes the fox bounce of walls, but keep them withing the bottom half of the screen
        if (ypos < 400 ){
            dy = -dy;

        }
        if (ypos > 800-height){
            dy = -dy;
            // xpos = 100-xpos;
        }
        if (xpos < 0){
            dx=-dx;
            // ypos = 800 - ypos;
        }
        if (xpos > 1000){
            dx=-dx;
            // ypos = 800 - ypos;
        }
    }
}






