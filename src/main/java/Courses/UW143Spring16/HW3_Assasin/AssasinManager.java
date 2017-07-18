package Courses.UW143Spring16.HW3_Assasin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AssasinManager {

    private AssassinNode head;
    private AssassinNode tail;
    private Map<String, String> graveyard;

    public AssasinManager(ArrayList<String> names) {
        graveyard = new HashMap<>();
        for (String aName : names) {
            //No new node created, we just connect circulation
            if (tail != null && aName.equals(tail.getName())) {
                tail.setNext(head);
                continue;
            }

            if (head == null) {
                head = new AssassinNode(aName, null);
                tail = head;
            }
            else {
                AssassinNode newNode;
                if (tail == head)
                    newNode = new AssassinNode(aName, tail);
                else
                    newNode = new AssassinNode(aName, head);

                head = newNode;
            }
        }
    }

    public String printKillRing() {
        StringBuilder sb = new StringBuilder();
        AssassinNode cur = head;

        while (cur.getNext() != head) {
            sb.append(cur.getName()).append(" is stalked by ").append(cur.getNext().getName()).append(".\n");
            cur = cur.getNext();
        }
        return sb.toString();
    }

    public String printGraveyard() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : graveyard.entrySet()) {
            sb.append(entry.getKey()).append(" was killed by ").append(entry.getValue()).append(".\n");
        }
        return sb.toString();
    }

    public boolean killRingContains(String name) {
        if (head == null)
            return false;

        AssassinNode cur = head;
        while (cur != tail) {
            if (cur.getName().equals(name))
                return true;

            cur = cur.getNext();
        }

        if (tail.getName().equals(name))
            return true;

        return false;
    }

    public boolean graveyardContains(String name) {
        return graveyard.containsKey(name);
    }

    public boolean isGameOver() {
        return (head == tail);
    }

    public String winner() {
        if (isGameOver())
            return head.getName();
        else
            return null;
    }

    public void kill(String name) {
        if (head == null || head == tail)
            return;

        AssassinNode cur = head;
        while (cur != tail) {
            if (head.getName().equals(name)) {
                tail.setNext(head.getNext());
                graveyard.put(head.getName(), tail.getName());
                head = head.getNext();
                return;
            }

            if (cur.getNext().getName().equals(name)) {
                graveyard.put(cur.getNext().getName(), cur.getName());
                if (cur.getNext().equals(tail))
                    tail = cur;

                cur.setNext(cur.getNext().getNext());
                return;
            }

            cur = cur.getNext();
        }
    }
}
