
package Problems.robot_world;

import csci152.adt.Stack;
import csci152.impl.ArrayStack;

import java.io.IOException;

public class RobotWorld {

	public static final char SPACE = ' ';
	public static final char WALL = '#';
	public static final char GOAL = 'G';

	public static final char NORTH = '^';
	public static final char SOUTH = 'V';
	public static final char EAST = '>';
	public static final char WEST = '<';
	
    // Fields

    // The map of the world
	private char[][] worldMap;
    
	// The dimensions of the world map
	private int maxRows, maxColumns;
	
	// The location of the robot
	private int robotRow, robotColumn;

	private WorldMapReader wmr;

    public RobotWorld(String mapFileName) throws IOException {

        wmr = new WorldMapReader();
        
    	// This loads the file data into the world map
        //WorldMapReader wmr = new WorldMapReader();
        worldMap = wmr.readWorldMap(mapFileName);
        
        // This saves the dimensions of the world map
        maxRows = wmr.getMaxRows();
        maxColumns = wmr.getMaxColumns();
        
        // This sets the location of the robot to the initial position
        // shown in the file
        robotRow = wmr.getInitRobotRow();
        robotColumn = wmr.getInitRobotColumn();
    }
    
 
    /**
     * Changes the direction of the robot by rotating it clockwise
     * 90 degrees
     */
    public void rotateClockwise() {

        if (worldMap[robotRow][robotColumn] == NORTH) {
            worldMap[robotRow][robotColumn] = EAST;

        } else if (worldMap[robotRow][robotColumn] == EAST) {
            worldMap[robotRow][robotColumn] = SOUTH;

        } else if (worldMap[robotRow][robotColumn] == SOUTH) {
            worldMap[robotRow][robotColumn] = WEST;

        } else if (worldMap[robotRow][robotColumn] == WEST) {
            worldMap[robotRow][robotColumn] = NORTH;
        }

    }
    
    
    /**
     * Changes the direction of the robot by rotating it counter-
     * clockwise 90 degrees
     */
    public void rotateCounterClockwise() {
        if (worldMap[robotRow][robotColumn] == NORTH) {
            worldMap[robotRow][robotColumn] = WEST;

        } else if (worldMap[robotRow][robotColumn] == WEST) {
            worldMap[robotRow][robotColumn] = SOUTH;

        } else if (worldMap[robotRow][robotColumn] == SOUTH) {
            worldMap[robotRow][robotColumn] = EAST;

        } else if (worldMap[robotRow][robotColumn] == EAST) {
            worldMap[robotRow][robotColumn] = NORTH;
        }

    }
    
    
    /**
     * Moves the robot forward one place, as long as it is not 
     * directly in front of a wall (if it is, throw an exception).
     * Also outputs a message if the robot finds the goal
     */
    public void moveForward() throws Exception {

//        if (worldMap[robotRow][robotColumn] == GOAL) {
//            System.out.println("SUCCESS!!!");
//            worldMap[robotRow][robotColumn] = SPACE;
//        }

    	if (worldMap[robotRow][robotColumn] == NORTH) {
    	    if (worldMap[robotRow - 1][robotColumn] == WALL) {throw new Exception("You have approached a wall");}
            worldMap[robotRow - 1][robotColumn] = worldMap[robotRow][robotColumn];
            worldMap[robotRow][robotColumn] = SPACE;
            robotRow--;

        } else if (worldMap[robotRow][robotColumn] == SOUTH) {
            if (worldMap[robotRow + 1][robotColumn] == WALL) {throw new Exception("You have approached a wall");}
            worldMap[robotRow + 1][robotColumn] = worldMap[robotRow][robotColumn];
            worldMap[robotRow][robotColumn] = SPACE;
            robotRow++;

        } else if (worldMap[robotRow][robotColumn] == EAST) {
            if (worldMap[robotRow][robotColumn + 1] == WALL) {throw new Exception("You have approached a wall");}
            worldMap[robotRow][robotColumn + 1] = worldMap[robotRow][robotColumn];
            worldMap[robotRow][robotColumn] = SPACE;
            robotColumn++;

        } else if (worldMap[robotRow][robotColumn] == WEST) {
            if (worldMap[robotRow][robotColumn - 1] == WALL) {throw new Exception("You have approached a wall");}
            worldMap[robotRow][robotColumn - 1] = worldMap[robotRow][robotColumn];
            worldMap[robotRow][robotColumn] = SPACE;
            robotColumn--;
        }

        if (worldMap[robotRow][robotColumn] == worldMap[wmr.getGoalRow()][wmr.getGoalColumn()]) {
            System.out.println("Success");
        }
    }
    
    
    public void printCurrentWorldMap() {
    	
    	for (int i = 0; i < maxRows; i++) {
    		for (int j = 0; j < maxColumns; j++) {
    			System.out.print(worldMap[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
