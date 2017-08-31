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
}
