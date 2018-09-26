//Buggle.java
//
//Benjamin Allan-Rahill
//
// Class to create Buggle and instance methods to move and change the direction
// of the Buggle

public class Buggle{


    // create the instance varaibles for (x,y) and
    //the direction that the Buggle is going in (EAST, SOUTH, WEST, NORTH)
    protected int xCoord;
    protected int yCoord;
    protected String direction;

    // construct a new Buggle
    public Buggle(){
        // Defaults: x = 1, y = 1, direction = EAST.
        xCoord = 1;
        yCoord = 1;
        direction = "EAST";
    }

    // move forward one grid cell
    public void forward(){
        forward(1); // calls the other, more general, constructor
    }
    // move forward 'k' grid cells
    public void forward(int k) {
        if (direction == ("EAST")) {
            xCoord += 1*k;
        }
        if (direction == ("SOUTH")) {
            yCoord -= 1*k;
        }
        if (direction == ("WEST")) {
            xCoord -= 1*k;
        }
        if (direction == ("NORTH")) {
            yCoord += 1*k;
        }
    }

    // rotate 90 degrees to right (EAST -> SOUTH -> WEST -> NORTH -> EAST)
    public void right(){
        if (direction == ("EAST")) {
            direction = "SOUTH";
        }
        else if (direction == ("SOUTH")) {
            direction = "WEST";
        }
        else if (direction == ("WEST")) {
            direction = "NORTH";
        }
        else if (direction == ("NORTH")) {
            direction = "EAST";
        }
    }

    // rotate 90 degrees to left (EAST -> NORTH -> WEST -> SOUTH -> EAST)
    public void left(){
        if (direction == ("EAST")) {
            direction = "NORTH";
        }
        else if (direction == ("SOUTH")) {
            direction = "EAST";
        }
        else if (direction == ("WEST")) {
            direction = "SOUTH";
        }
        else if (direction == ("NORTH")) {
            direction = "WEST";
        }
    }

    // return a string representation of the object
    public String toString(){
        return ("x=" + xCoord + ", y =" + yCoord + ", direction=" + this.direction);
    }
}
