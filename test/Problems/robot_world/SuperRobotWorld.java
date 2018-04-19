
package Problems.robot_world;

import Problems.robot_world.RobotWorld;
import csci152.adt.Stack;
import csci152.impl.ArrayStack;

import java.io.IOException;

public class SuperRobotWorld extends RobotWorld {

//    public static final char SPACE = ' ';
//    public static final char WALL = '#';
//    public static final char GOAL = 'G';
//
//    public static final char NORTH = '^';
//    public static final char SOUTH = 'V';
//    public static final char EAST = '>';
//    public static final char WEST = '<';

    // Fields
    private Stack<Character> movements = new ArrayStack();
    private Stack<Character> undos = new ArrayStack();

//    // The map of the world
//    private char[][] worldMap;
//
//    // The dimensions of the world map
//    private int maxRows, maxColumns;
//
//    // The location of the robot
//    private int robotRow, robotColumn;

    public SuperRobotWorld(String mapFile) throws IOException {
        super(mapFile);
    }

    @Override
    public void moveForward() throws Exception {

        super.moveForward();
        movements.push('F');

//        if (worldMap[robotRow][robotColumn] == GOAL) {
//            System.out.println("SUCCESS!!!");
//            worldMap[robotRow][robotColumn] = SPACE;
//        }
//
//        if (worldMap[robotRow][robotColumn] == NORTH) {
//            if (worldMap[robotRow - 1][robotColumn] == WALL) {throw new Exception("You have approached a wall");}
//            worldMap[robotRow - 1][robotColumn] = worldMap[robotRow][robotColumn];
//            worldMap[robotRow][robotColumn] = SPACE;
//            robotRow--;
//            movements.push('N');
//
//        } else if (worldMap[robotRow][robotColumn] == SOUTH) {
//            if (worldMap[robotRow + 1][robotColumn] == WALL) {throw new Exception("You have approached a wall");}
//            worldMap[robotRow + 1][robotColumn] = worldMap[robotRow][robotColumn];
//            worldMap[robotRow][robotColumn] = SPACE;
//            robotRow++;
//            movements.push('S');
//
//        } else if (worldMap[robotRow][robotColumn] == EAST) {
//            if (worldMap[robotRow][robotColumn + 1] == WALL) {throw new Exception("You have approached a wall");}
//            worldMap[robotRow][robotColumn + 1] = worldMap[robotRow][robotColumn];
//            worldMap[robotRow][robotColumn] = SPACE;
//            robotColumn++;
//            movements.push('E');
//
//        } else if (worldMap[robotRow][robotColumn] == WEST) {
//            if (worldMap[robotRow][robotColumn - 1] == WALL) {throw new Exception("You have approached a wall");}
//            worldMap[robotRow][robotColumn - 1] = worldMap[robotRow][robotColumn];
//            worldMap[robotRow][robotColumn] = SPACE;
//            robotColumn--;
//            movements.push('W');
//        }
    }

//    public void moveBackward() throws Exception {
//        char x = movements.pop();

//        if (x == 'N') {
//            worldMap[robotRow + 1][robotColumn] = worldMap[robotRow][robotColumn];
//            worldMap[robotRow][robotColumn] = SPACE;
//            robotRow++;
//            undos.push('N');
//
//        } else if (x == 'S') {
//            worldMap[robotRow - 1][robotColumn] = worldMap[robotRow][robotColumn];
//            worldMap[robotRow][robotColumn] = SPACE;
//            robotRow--;
//            undos.push('S');
//
//        } else if (x == 'E') {
//            worldMap[robotRow][robotColumn - 1] = worldMap[robotRow][robotColumn];
//            worldMap[robotRow][robotColumn] = SPACE;
//            robotColumn--;
//            undos.push('E');
//
//        } else if (x == 'W') {
//            worldMap[robotRow][robotColumn + 1] = worldMap[robotRow][robotColumn];
//            worldMap[robotRow][robotColumn] = SPACE;
//            robotColumn++;
//            undos.push('W');
//        }
//    }

    @Override
    public void rotateClockwise() {
        super.rotateClockwise();
        char rotation = 'O';
        movements.push(rotation);
    }

    @Override
    public void rotateCounterClockwise() {
        super.rotateCounterClockwise();
        char rotation = 'U';
        movements.push(rotation);
    }
    
    /**
     * Undo the last move or rotation command that put the robot
     * in its current state.  If no commands have been issued yet,
     * do nothing.
     */
    public void undoCommand() {
        try {
            char x = movements.pop();

            if (x == 'O') {
                rotateCounterClockwise();
                undos.push('U');
            } else if (x == 'U') {
                rotateClockwise();
                undos.push('O');
            } else if (x == 'F') {
                super.rotateClockwise();
                super.rotateClockwise();
                super.moveForward();
                super.rotateClockwise();
                super.rotateClockwise();
                undos.push('F');
                return;
            }

        } catch (Exception e) {
            System.out.println("Nothing to undo");
        }
    }
    
    /**
     * Undo the last n commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to undo
     */
    public void undoCommands(int n) {
        for (int i = 0; i < n; i++) {
            undoCommand();
        }
    }
    
    /**
     * For previously undone commands, redo the last command that was
     * undone
     */
    public void redoUndoneCommand() {
        try {
            char x = undos.pop();

            if (x == 'O') {
                rotateClockwise();
            } else if (x == 'U') {
                rotateCounterClockwise();
            } else {
                moveForward();
            }

        } catch (Exception e) {
            System.out.println("Nothing to undo");
        }
    }
    
    /**
     * Redo the last n undone commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to redo
     */
    public void redoUndoneCommands(int n) {
        for (int i = 0; i < n; i++) {
            redoUndoneCommand();
        }
    }
}
