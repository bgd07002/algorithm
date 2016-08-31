package AdvancedAlgorithms.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class ActivitySelection {

    private ArrayList<Integer> activityList;

    public ActivitySelection() {
        activityList = new ArrayList<>();
    }

    public ArrayList<Integer> getActivityList() {
        return activityList;
    }

    public void activitySelect(HashMap<Integer, Integer[]> activitySet) {
        CurrentActivity currentActivity = new CurrentActivity(-1, -1, false);
        while (!currentActivity.isActivityCompleted()) {
            currentActivity = activitySelectHelper(activitySet, currentActivity);
        }
    }

    private CurrentActivity activitySelectHelper(HashMap<Integer, Integer[]> activitySet, CurrentActivity currentActivity) {
        int minStart = -1;
        int minEnd = -1;
        int minKey = -1;

        for (HashMap.Entry<Integer, Integer[]> entry : activitySet.entrySet()) {
            int key = entry.getKey();
            Integer[] value = entry.getValue();

            if (value[0] >= currentActivity.getCurEnd()) {
                if (minEnd == -1 || value[1] < minEnd) {
                    minStart = value[0];
                    minEnd = value[1];
                    minKey = key;
                }
            }
        }

        if (minStart > 0 && minEnd > 0) {
            currentActivity = new CurrentActivity(minStart, minEnd, false);
            activityList.add(minKey);
        } else
            currentActivity.activityCompleted = true;

        return currentActivity;
    }

    private class CurrentActivity {
        private int curStart;
        private int curEnd;
        private boolean activityCompleted;

        public CurrentActivity(int curStart, int curEnd, boolean activityCompleted) {
            this.curStart = curStart;
            this.curEnd = curEnd;
            this.activityCompleted = activityCompleted;
        }

        public int getCurEnd() {
            return curEnd;
        }

        public boolean isActivityCompleted() {
            return activityCompleted;
        }
    }
}
