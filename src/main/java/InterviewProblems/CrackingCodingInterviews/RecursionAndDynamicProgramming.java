package InterviewProblems.CrackingCodingInterviews;

public class RecursionAndDynamicProgramming {

    /**
     * 8.1 Triple Steps - A child is running up a staircase with n steps and can hop either 1 step, 2 steps and 3 steps at a time.
     * Implement a method to count how many possible ways the child can run up the stairs.
     */
    public int tripleSteps(int n) {
        return tripleStepsHelper(n, 3);
    }

    private int tripleStepsHelper(int n, int denom) {
        int next_denom = 0;

        switch (denom) {
            case 3:
                next_denom = 2;
                break;
            case 2:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }

        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += tripleStepsHelper(n - i * denom, next_denom);
        }
        return ways;
    }

    /**
     * 8.2 Robot in a grid: Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can only move in two directions:
     * right and down. How many possible paths are there for the robot?
     */

}
