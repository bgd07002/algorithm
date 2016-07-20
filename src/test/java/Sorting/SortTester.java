package Sorting;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SortTester {

    @Test
    public void insertionSortTest() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 5, 3, 1, 8, 7, 2, 4));
        ISorter<Integer> sorter = new InsertionSort<Integer>();
        sorter.sortList(list);
        Assert.assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7, 8}, list.toArray());

        ArrayList<String> listString = new ArrayList<String>(Arrays.asList("Hello", "This", "is", "Baha"));
        ISorter<String> sorterStr = new InsertionSort<String>();
        sorterStr.sortList(listString);
        Assert.assertArrayEquals(new Object[]{"Baha", "Hello", "This", "is"}, listString.toArray());

        ArrayList<Integer> listDuplicate = new ArrayList<Integer>(Arrays.asList(6, 5, 7, 1, 8, 7, 2, 2));
        sorter.sortList(listDuplicate);
        Assert.assertArrayEquals(new Object[]{1, 2, 2, 5, 6, 7, 7, 8}, listDuplicate.toArray());
    }

    @Test
    public void mergeSortTest() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 5, 3, 1, 8, 7, 2, 4));
        ISorter<Integer> sorter = new MergeSort<Integer>();
        sorter.sortList(list);
        Assert.assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7, 8}, list.toArray());

        ArrayList<Integer> listDuplicate = new ArrayList<Integer>(Arrays.asList(6, 5, 7, 2, 8, 1, 2));
        sorter.sortList(listDuplicate);
        Assert.assertArrayEquals(new Object[]{1, 2, 2, 5, 6, 7, 8}, listDuplicate.toArray());
    }

    @Test
    public void quickSortTest() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 3, 12, 9, 7, 14, 2, 5, 10));
        ISorter<Integer> sorter = new QuickSort<Integer>();
        sorter.sortList(list);
        Assert.assertArrayEquals(new Object[]{2, 3, 5, 6, 7, 9, 10, 12, 14}, list.toArray());

        ArrayList<Integer> listDuplicate = new ArrayList<Integer>(Arrays.asList(6, 5, 7, 2, 8, 1, 2));
        sorter.sortList(listDuplicate);
        Assert.assertArrayEquals(new Object[]{1, 2, 2, 5, 6, 7, 8}, listDuplicate.toArray());
    }

    @Test
    public void bubbleSortTest() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 3, 12, 9, 7, 14, 2, 5, 10));
        ISorter<Integer> sorter = new BubbleSort<Integer>();
        sorter.sortList(list);
        Assert.assertArrayEquals(new Object[]{2, 3, 5, 6, 7, 9, 10, 12, 14}, list.toArray());

        ArrayList<Integer> listDuplicate = new ArrayList<Integer>(Arrays.asList(6, 5, 7, 2, 8, 1, 2));
        sorter.sortList(listDuplicate);
        Assert.assertArrayEquals(new Object[]{1, 2, 2, 5, 6, 7, 8}, listDuplicate.toArray());
    }
}
