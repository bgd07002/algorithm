package Courses.UW143Spring16.HW3_Assasin;

public class AssassinNode {
    private String name;
    private String killer;
    private AssassinNode next;

    public AssassinNode(String name, AssassinNode next) {
        this.name = name;
        this.next = next;
    }

    public void setKiller(String killer) {
        this.killer = killer;
    }

    public String getName() {
        return name;
    }

    public String getKiller() {
        return killer;
    }

    public AssassinNode getNext() {
        return next;
    }

    public void setNext(AssassinNode next) {
        this.next = next;
    }
}
