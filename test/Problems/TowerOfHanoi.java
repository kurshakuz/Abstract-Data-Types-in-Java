package Problems;

import csci152.adt.Stack;
import csci152.impl.ArrayStack;

public class TowerOfHanoi {

    private Stack<Integer>[] post = new ArrayStack[3];
    private int numMoves = 0;
    int n;

    public TowerOfHanoi(int numDiscs) {
        post[0] = new ArrayStack();
        post[1] = new ArrayStack();
        post[2] = new ArrayStack();
        n = numDiscs;

        for (int i = numDiscs; i > 0; i--) {
            post[0].push(i);
        }
    }

    public void moveDisc(int from, int to) throws Exception {
        if (from < 0 || from > 2 || to < 0 || to > 2) {
            throw new Exception("Integers out of range!");
        }

        int x;
        int y;
        if (post[from].getSize() != 0) {
            x = post[from].pop();
            if (post[to].getSize() == 0) {
                post[to].push(x);
                numMoves++;
            } else {
                y = post[to].pop();
                if (x < y) {
                    post[to].push(y);
                    post[to].push(x);
                    numMoves++;
                } else {
                    post[from].push(x);
                    post[from].push(y);
                    numMoves++;
                }
            }
        } else {
            if (post[to].getSize() != 0) {
                y = post[to].pop();
                post[from].push(y);
                numMoves++;
            } else {
                return;
            }
        }
        return;


//        } else if(post[from].getSize() != 0) {
//            x = post[from].pop();
//            post[to].push(x);
//        } else if(post[to].getSize() != 0) {
//            y = post[to].pop();
//            post[from].push(y);
//        }

//        if (post[to].getSize() != 0) {
//            y = post[to].pop();
//            if (x < y) {
//                post[to].push(y);
//                post[to].push(x);
//                numMoves++;
//            } else {
//                post[to].push(y);
//                throw new Exception("Condition for move is not satisfied");
//            }
//        } else {
//            post[to].push(x);
//            numMoves++;
//        }


    }

    public boolean isFinished() {
        if (post[0].getSize() == 0 && post[1].getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumMoves() {
        return numMoves;
    }

    public String toString() {
        String m = "First tower: ";
        m += post[0].toString() + "\n"
                + "Second tower: " + post[1].toString() + "\n"
                + "Third tower: " + post[2].toString() + "\n"
                + "Number of moves: " + getNumMoves() + "\n"
                + "Puzzle finished: " + isFinished() + "\n";
        return m;
    }

//    public void Solver(int n) throws Exception {
//        TowerOfHanoi tower = new TowerOfHanoi(n);
//        if (n % 2 != 0) {
//            //while (tower.isFinished() != true) {
//            for (int i = 0; i < 2; i++) {
//                moveDisc(0, 2);
//                System.out.println(tower);
//                moveDisc(0, 1);
//                System.out.println(tower);
//                moveDisc(1, 2);
//                System.out.println(tower);
//            }
//        } else {
//            //while (tower.isFinished() != true) {
//            for (int i = 0; i < 5; i++) {
//                moveDisc(0, 1);
//                moveDisc(0, 2);
//                moveDisc(1, 2);
//            }
//
//        }
//    }

}