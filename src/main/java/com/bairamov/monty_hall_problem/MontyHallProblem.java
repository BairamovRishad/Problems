package com.bairamov.monty_hall_problem;

/*
* Suppose you're on a game show, and you're given the choice of three doors: Behind one door is a car; behind the others, goats. You pick a door, say No. 1, and the host, who knows what's behind the doors, opens another door, say No. 3, which has a goat. He then says to you, "Do you want to pick door No. 2?" Is it to your advantage to switch your choice?
* */

import java.util.concurrent.ThreadLocalRandom;

public class MontyHallProblem {
    public static void main(String[] args) {
        new MontyHallProblem().solveBySimulation();
    }

    private void solveBySimulation() {
        final long MAX_ATTEMPTS = 1_000_000_000;
        long winsIfNotSwitching = 0;
        long winsIfSwitching = 0;

        // System.out.println("Car Door | First Picked Door | Shown Door | Switched Door");

        for (long i = 0; i < MAX_ATTEMPTS; i++) {
            // The car is behind the door with No. carDoorNo
            final int carDoorNo = ThreadLocalRandom.current().nextInt(3);

            // In the first time the player picks the door with No. firstPickedDoorNo
            final int firstPickedDoorNo = ThreadLocalRandom.current().nextInt(3);

            // The shown door will bw the door with No. that is neither carDoorNo nor firstPickedDoorNo
            int shownDoorNo;
            do {
                shownDoorNo = ThreadLocalRandom.current().nextInt(3);
            } while ((shownDoorNo == carDoorNo) || (shownDoorNo == firstPickedDoorNo));

            if (firstPickedDoorNo == carDoorNo) {
                winsIfNotSwitching++;
            }

            // Calculate the switchedDoorNo
            int switchedDoorNo = 3 - firstPickedDoorNo - shownDoorNo;

            if (switchedDoorNo == carDoorNo) {
                winsIfSwitching++;
            }

           // System.out.printf("%-9d%-19d%-12d%-14d%n", carDoorNo, firstPickedDoorNo, shownDoorNo, switchedDoorNo);
        }

        System.out.println("Result if the player does not switch the first choice: ");
        System.out.printf("The player won %d times out of %d. The probability is %.3f%n", winsIfNotSwitching, MAX_ATTEMPTS, winsIfNotSwitching * 1.0 / MAX_ATTEMPTS);
        System.out.println();
        System.out.println("Result if the player switches the first choice: ");
        System.out.printf("The player won %d times out of %d. The probability is %.3f%n", winsIfSwitching, MAX_ATTEMPTS, winsIfSwitching * 1.0 / MAX_ATTEMPTS);
    }
}
