package LeetCode;


public class Algorithms {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8

     Assumption: Definition for singly-linked list.
     */
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carryOver = 0;
        ListNode sumNode = null;

        while (l1 != null || l2 != null) {

            int l1Int = 0, l2Int = 0;
            if (l1 != null)
                l1Int = l1.val;

            if (l1 != null)
                l2Int = l2.val;

            sumNode = new ListNode((l1Int + l2Int + carryOver) % 10);
            carryOver = (l1Int + l2Int + carryOver) /10;

            l1 = l1.next;
            l2 = l2.next;
            sumNode = sumNode.next;
        }
        return null;
    }

    private void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode output = addTwoNumbers(l1, l2);
        System.out.println(output.val);
        System.out.println(output.next.val);
        System.out.println(output.next.next.val);
    }



    public static void main(String args[]) {
        Algorithms a = new Algorithms();
        a.test();
    }
}
