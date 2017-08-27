package Algorithms.GreedyAlgorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedyAlgorithm {

    /**
     * Prints a maximum set of activities that can be done by a single person, one at a time.
     *  s[] -->  An array that contains start time of all activities
     *  f[] -->  An array that contains finish time of all activities
     */
    public List<Integer> activitySelection(int[] s, int[] f) {
        if (s.length != f.length)
            return null;

        List<Integer> activityList = new ArrayList<>();

        int i = 0;
        activityList.add(i);
        for (int j = 1; j < f.length; j++) {
            if (s[j] > f[i]) {
                activityList.add(j);
                i = j;
            }
        }

        return activityList;
    }

    /**
     * 18.1 Compute optimally minimum delay after task assignments. Each worker can be assigned two tasks
     */
    public int optimalTaskAssignment(int[] assignments) {
        //O(nlogn)
        Arrays.sort(assignments);

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

        Arrays.sort(waitingTimes);
        for (int i=0; i< waitingTimes.length-1; i++) {
            for (int j=0; j<= i; j++)
                delay += waitingTimes[j];
        }
        return delay;
    }
}
