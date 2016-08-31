package AdvancedAlgorithms.GreedyAlgorithms;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;

public class ActivitySelectionTest {

    @Test
    public void activitySelectionTest() {

        ActivitySelection a = new ActivitySelection();
        HashMap<Integer, Integer[]> activitySet = new HashMap<>();
        activitySet.put(0, new Integer[]{1,2});
        activitySet.put(1, new Integer[]{3,4});
        activitySet.put(2, new Integer[]{0,6});
        activitySet.put(3, new Integer[]{5,7});
        activitySet.put(4, new Integer[]{8,9});
        activitySet.put(5, new Integer[]{5,9});

        a.activitySelect(activitySet);
        ArrayList<Integer> actualList = a.getActivityList();
        int[] expectedArr = new int[]{0,1,3,4};
        Assert.assertEquals(expectedArr.length, actualList.size());

        //Comparing elements
        for (int i=0; i< expectedArr.length; i++)
            Assert.assertEquals(expectedArr[i], (int)actualList.get(i));
    }
}
