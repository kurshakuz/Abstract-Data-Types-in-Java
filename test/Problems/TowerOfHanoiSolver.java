package Problems;

import csci152.impl.ArrayStack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TowerOfHanoiSolver {

    public static TowerOfHanoi Solver(int n, TowerOfHanoi tower) throws Exception {
        if ((n % 2) != 0) {
            while (true) {
                if (tower.isFinished()) {
                    break;
                } else {
                    tower.moveDisc(0, 2);
                }

                if (tower.isFinished()) {
                    break;
                } else {
                    tower.moveDisc(0, 1);
                }

                if (tower.isFinished()) {
                    break;
                } else {
                    tower.moveDisc(1, 2);
                }
            }
        } else {
            while (true) {
                if (tower.isFinished()) {
                    break;
                } else {
                    tower.moveDisc(0, 1);
                }

                if (tower.isFinished()) {
                    break;
                } else {
                    tower.moveDisc(0, 2);
                }

                if (tower.isFinished()) {
                    break;
                } else {
                    tower.moveDisc(1, 2);
                }
            }
        }

        return tower;
    }

    public static void main(String[] args) throws Exception {
        int n = 5;

        TowerOfHanoi tower = new TowerOfHanoi(n);

        System.out.println(tower);

        tower = Solver(n, tower);

        System.out.println(tower);

    }
}
