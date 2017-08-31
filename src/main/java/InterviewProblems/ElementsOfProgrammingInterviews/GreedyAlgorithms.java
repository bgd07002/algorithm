package InterviewProblems.ElementsOfProgrammingInterviews;

public class GreedyAlgorithms {

    /**
     * 18.1 Compute optimally minimum delay after task assignments. Each worker can be assigned two tasks
     */
    public int optimalTaskAssignment(int[] assignments) {
        //O(nlogn)
        java.util.Arrays.sort(assignments);

        int delay = 0;
        for (int i=0, j= assignments.length-1; i<j; i++, j--) {
            delay = (assignments[i] + assignments[j] > delay)? assignments[i]+assignments[j]: delay;
        }
        return delay;
    }

    /**
     * 18.2 Database has waiting times. Minimize total waiting time.
     * Example: {2,5,1,3}
     */
    public int minimalWaitingTime(int[] waitingTimes) {
        //Without Greedy algorithm, waiting time is O(n!)
        int delay = 0;

        java.util.Arrays.sort(waitingTimes);
        for (int i=0; i< waitingTimes.length-1; i++) {
            for (int j=0; j<= i; j++)
                delay += waitingTimes[j];
        }
        return delay;
    }
}
