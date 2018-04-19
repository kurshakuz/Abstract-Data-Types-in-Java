
package Problems.robot_world;

import Problems.robot_world.SuperRobotWorld;
import Problems.robot_world.RobotWorld;

public class Tester {
    
    public static void main(String[] args) throws Exception {
        
        SuperRobotWorld rw = new SuperRobotWorld("test/Problems/robot_world/map1.txt");
        rw.printCurrentWorldMap();
        
        rw.moveForward();
        rw.printCurrentWorldMap();

        rw.rotateClockwise();
        rw.printCurrentWorldMap();

        rw.moveForward();
       	rw.printCurrentWorldMap();
        
        for (int i = 0; i < 5; i++) {
        	rw.moveForward();
        	rw.printCurrentWorldMap();
        }

        rw.undoCommand();
        rw.printCurrentWorldMap();

        rw.moveForward();
        rw.printCurrentWorldMap();

        rw.rotateClockwise();
        rw.printCurrentWorldMap();

        for (int i = 0; i < 6; i++) {
            rw.moveForward();
            rw.printCurrentWorldMap();
        }

        rw.rotateClockwise();
        rw.printCurrentWorldMap();

        for (int i = 0; i < 5; i++) {
            rw.moveForward();
            rw.printCurrentWorldMap();
        }

        rw.rotateClockwise();
        rw.printCurrentWorldMap();

        for (int i = 0; i < 3; i++) {
            rw.moveForward();
            rw.printCurrentWorldMap();
        }

        rw.rotateClockwise();
        rw.printCurrentWorldMap();

        rw.moveForward();
        rw.printCurrentWorldMap();
        rw.moveForward();


        rw.undoCommand();
        rw.printCurrentWorldMap();
        rw.undoCommand();
        rw.printCurrentWorldMap();

        rw.redoUndoneCommand();
        rw.printCurrentWorldMap();

        rw.redoUndoneCommand();
        rw.printCurrentWorldMap();
    }
}
