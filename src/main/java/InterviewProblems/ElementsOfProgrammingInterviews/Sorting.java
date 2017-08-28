package InterviewProblems.ElementsOfProgrammingInterviews;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sorting<T extends Comparable<T>> {

    /**
     * 14.1
     */
    public List<Integer> intersectionOfTwoSortedArrays(int[] arr1, int[] arr2) {

        int cur1=0, cur2=0;
        List<Integer> intersectionList = new ArrayList<>();
        while (cur1 < arr1.length && cur2 < arr2.length) {
            if (arr1[cur1] > arr2[arr2.length-1] || arr2[cur2] > arr1[arr1.length-1])
                break;

            if (arr1[cur1] == arr2[cur2]) {
                if (intersectionList.isEmpty() || !intersectionList.get(intersectionList.size()-1).equals(arr1[cur1]))
                    intersectionList.add(arr1[cur1]);
                cur1++;
                cur2++;
            } else if (arr1[cur1] > arr2[cur2])
                cur2++;
            else
                cur1++;
        }
        return intersectionList;
    }

    /**
     * 14.2 Merge Two Sorted Arrays
     * 14.3 Remove First Name Duplicates
     */
    public List<String[]> removeFirstNameDuplicates(List<String[]> names) {
        Map<String,String> mapNames = new TreeMap();
        for (String[] aName : names)
            mapNames.put(aName[0],aName[1]);

        List<String[]> result = new ArrayList<>();
        for (String firstName: mapNames.keySet())
            result.add(new String[]{firstName, mapNames.get(firstName)});

        return result;
    }

}
